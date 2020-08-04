package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridUsersInRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface XpGridUsersInRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XpGridUsersInRoles record);

    int insertSelective(XpGridUsersInRoles record);

    XpGridUsersInRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XpGridUsersInRoles record);

    int updateByPrimaryKey(XpGridUsersInRoles record);
}