package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsForPublic;

import java.util.List;

//@Repository
public interface XpGridFunctionsForPublicMapperPlus
{
    //自定义
    List<XpGridFunctionsForPublic> selectListByUserId();
}