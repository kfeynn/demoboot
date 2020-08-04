package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsForPublic;
import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsForPublicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface XpGridFunctionsForPublicMapper {
    long countByExample(XpGridFunctionsForPublicExample example);

    int deleteByExample(XpGridFunctionsForPublicExample example);

    int deleteByPrimaryKey(String funccode);

    int insert(XpGridFunctionsForPublic record);

    int insertSelective(XpGridFunctionsForPublic record);

    List<XpGridFunctionsForPublic> selectByExample(XpGridFunctionsForPublicExample example);

    XpGridFunctionsForPublic selectByPrimaryKey(String funccode);

    int updateByExampleSelective(@Param("record") XpGridFunctionsForPublic record, @Param("example") XpGridFunctionsForPublicExample example);

    int updateByExample(@Param("record") XpGridFunctionsForPublic record, @Param("example") XpGridFunctionsForPublicExample example);

    int updateByPrimaryKeySelective(XpGridFunctionsForPublic record);

    int updateByPrimaryKey(XpGridFunctionsForPublic record);
}