package cn.grand.demoboot.helper;

import cn.grand.demoboot.mapper.supplier.SupCommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupRDBSHelper
{
    @Autowired
    SupCommonMapper supCommonMapper;

    /// <summary>
    /// 执行分页查询
    /// </summary>
    /// <typeparam name="T">泛型 需要有对应的实体类</typeparam>
    /// <param name="tablename">表、视图</param>
    /// <param name="orderfield">排序字段、主键</param>
    /// <param name="sqlwhere">查询条件</param>
    /// <param name="pagesize">页面显示数量</param>
    /// <param name="pageindex">页码</param>
    /// <param name="totalrecord">总记录数</param>
    /// <returns></returns>
    public Map ExecutePaging(String tablename, String orderfield, String sqlwhere, int pagesize, int pageindex,int totalrecord)
    {
        //Oracle 。不能通过存储过程。
        String cmdStr = GetCmdStr(tablename, orderfield, sqlwhere, pagesize, pageindex);
        //执行存储过程.  返回类型用视图实体类 。
        List<LinkedHashMap<String, Object>> list = supCommonMapper.commonSelect(cmdStr);

        //list 去除 ROWNO 字段 ,使返回完整的table实体集，没有多余字段（ROWNO）
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap row = list.get(i);
            row.remove("ROWNO");
        }
        //获取 table、sqlwhere 总记录数
        totalrecord = GetTableSqlwhereCount(tablename, sqlwhere);
        //totalrecord = 10 ;
        //分页约定2个返回值
        Map map = new HashMap();
        map.put("list", list);  //数据列表
        map.put("totalRecord", totalrecord); //总记录数
        return map;
    }

    /// <summary>
    /// 获取记录总数
    /// </summary>
    /// <param name="tablename"></param>
    /// <param name="sqlwhere"></param>
    /// <returns></returns>
    public int GetTableSqlwhereCount(String tablename, String sqlwhere)
    {
        int count = 0;
        String cmdStr = " select count(0) from " + tablename + " " + sqlwhere;
        //获取个数。
        count = supCommonMapper.commonSelectInt(cmdStr);
        return count;
    }


    /// <summary>
    /// 获取查询分页 字符串
    /// </summary>
    /// <param name="tablename"></param>
    /// <param name="orderfield">field desc,field2 asc</param>
    /// <param name="sqlwhere">必须传入查询条件。没有就where 1=1 </param>
    /// <param name="pagesize">传参前先判断总数量</param>
    /// <param name="pageindex">传参前先半盘总页数</param>
    /// <returns></returns>
    public String GetCmdStr(String tablename, String orderfield, String sqlwhere, int pagesize, int pageindex)
    {
        String cmdstr = "";
        //起始条数、截止条数
        int rownum;
        int rowno;
        rownum = pagesize * pageindex;
        rowno = pagesize * (pageindex - 1);
        //sql基础模板
        if (orderfield.length() <= 0)
        {
            //没有orderby
            //cmdstr = "SELECT * FROM(SELECT ROWNUM AS rowno, t.* FROM tc_brd_file t WHERE tc_brd08 BETWEEN TO_DATE('20180501', 'yyyymmdd') AND TO_DATE('20180731', 'yyyymmdd') AND ROWNUM <= 20 * 3) table_alias WHERE table_alias.rowno > 20 * (3 - 1);";
            cmdstr = "SELECT * FROM(SELECT ROWNUM AS rowno, t.* FROM %s t %s AND ROWNUM <= %d) table_alias WHERE table_alias.rowno > %d";

            cmdstr = String.format(cmdstr,
                    tablename,
                    sqlwhere,
                    rownum,
                    rowno
            );
        }
        else
        {
            //有orderby .每页20行。第三页
            //cmdstr = "SELECT * FROM(SELECT ROWNUM AS rowno, r.* FROM( SELECT * FROM tc_brd_file WHERE tc_brd08 BETWEEN TO_DATE('20180501', 'yyyymmdd') AND TO_DATE('20180731', 'yyyymmdd') ORDER BY tc_brd08 desc ) r where ROWNUM <= 20 * 3 ) table_alias WHERE table_alias.rowno > 20 * (3 - 1);";
            cmdstr = "SELECT * FROM(SELECT ROWNUM AS rowno, r.* FROM( SELECT * FROM %s %s ORDER BY %s ) r where ROWNUM <= %d ) table_alias WHERE table_alias.rowno > %d";

            cmdstr = String.format(cmdstr,
                    tablename,
                    sqlwhere,
                    orderfield,
                    rownum,
                    rowno
            );
        }

        return cmdstr;
    }



}
