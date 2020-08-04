package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridFuncsInRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface XpGridFuncsInRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XpGridFuncsInRoles record);

    int insertSelective(XpGridFuncsInRoles record);

    XpGridFuncsInRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XpGridFuncsInRoles record);

    int updateByPrimaryKey(XpGridFuncsInRoles record);
}