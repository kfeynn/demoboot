package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface XpGridFunctionsMapper {
    long countByExample(XpGridFunctionsExample example);

    int deleteByExample(XpGridFunctionsExample example);

    int deleteByPrimaryKey(String funccode);

    int insert(XpGridFunctions record);

    int insertSelective(XpGridFunctions record);

    List<XpGridFunctions> selectByExample(XpGridFunctionsExample example);

    XpGridFunctions selectByPrimaryKey(String funccode);

    int updateByExampleSelective(@Param("record") XpGridFunctions record, @Param("example") XpGridFunctionsExample example);

    int updateByExample(@Param("record") XpGridFunctions record, @Param("example") XpGridFunctionsExample example);

    int updateByPrimaryKeySelective(XpGridFunctions record);

    int updateByPrimaryKey(XpGridFunctions record);
}