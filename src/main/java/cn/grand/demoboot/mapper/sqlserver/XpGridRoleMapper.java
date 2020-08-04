package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridRole;
import cn.grand.demoboot.entity.sqlserver.XpGridRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface XpGridRoleMapper {
    long countByExample(XpGridRoleExample example);

    int deleteByExample(XpGridRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(XpGridRole record);

    int insertSelective(XpGridRole record);

    List<XpGridRole> selectByExample(XpGridRoleExample example);

    XpGridRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") XpGridRole record, @Param("example") XpGridRoleExample example);

    int updateByExample(@Param("record") XpGridRole record, @Param("example") XpGridRoleExample example);

    int updateByPrimaryKeySelective(XpGridRole record);

    int updateByPrimaryKey(XpGridRole record);
}