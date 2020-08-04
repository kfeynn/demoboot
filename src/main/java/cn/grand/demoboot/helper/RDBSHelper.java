package cn.grand.demoboot.helper;

import cn.grand.demoboot.mapper.sqlserver.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RDBSHelper
{
    @Autowired
    CommonMapper commonMapper;
    //最后两个参数为返回参数
    public Map ExecutePaging(String tablename, String fileds, String orderfield,
                                                            String sqlwhere, int pagesize, int pageindex,
                                                            int totalpage,  int totalrecord)
    {
        //准备参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName",tablename);
        paramMap.put("fields",fileds);
        paramMap.put("orderField",orderfield);
        paramMap.put("sqlWhere",sqlwhere);
        paramMap.put("pageSize",pagesize);
        paramMap.put("pageIndex",pageindex);
        paramMap.put("totalPage",totalpage);     //存储过程输出参数
        paramMap.put("totalRecord",totalrecord); //存储过程输出参数

        //执行存储过程.  返回类型用视图实体类 。
        List<LinkedHashMap<String,Object>>  list =  commonMapper.Paging(paramMap);
        //获取 输出参数返回值
        //totalpage = (int)paramMap.get("totalPage");
        totalrecord =(int)paramMap.get("totalRecord");

        //分页约定2个返回值
        Map map = new HashMap();
        map.put("list", list);   //数据列表
        map.put("totalRecord", totalrecord);  //总记录数
        return map;

        //return list;
    }
}
