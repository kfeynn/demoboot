package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;

import java.util.List;


//XpGridFunctionsMapperPlus 带Plus 是对XpGridFunctionsMapper进行改写。
// 增加方法，不对生成的文件进行改动。
public interface XpGridFunctionsMapperPlus
{
    //自定义
    List<XpGridFunctions> selectListByUserId(int sid);
}