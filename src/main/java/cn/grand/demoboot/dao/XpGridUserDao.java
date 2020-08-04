package cn.grand.demoboot.dao;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.entity.sqlserver.XpGridUsersInRoles;
import cn.grand.demoboot.mapper.sqlserver.XpGridUserMapper;
import cn.grand.demoboot.mapper.sqlserver.XpGridUserMapperPlus;
import cn.grand.demoboot.mapper.sqlserver.XpGridUsersInRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XpGridUserDao
{
    @Autowired
    XpGridUserMapper xpGridUserMapper;
    @Autowired
    XpGridUserMapperPlus xpGridUserMapperPlus;

    @Autowired
    XpGridUsersInRolesMapper xpGridUsersInRolesMapper;

    //获取用户信息
    public XpGridUser getModelByUserID(int sid)
    {
        return xpGridUserMapper.selectByPrimaryKey(sid);
    }
    /**
     * 判断用户密码是否存在
     * @param username
     * @param password
     * @return
     */
    public boolean isExists(String username,String password)
    {
        int i = xpGridUserMapperPlus.isExists(username,password);
        if(i>0)
            return true;
        else
            return false;
    }

    /**
     * 根据用户名密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public XpGridUser selectByUserNameAndPassword(String username,String password)
    {
        return xpGridUserMapperPlus.selectByUserNameAndPassword(username,password);
    }


    public int insert(XpGridUser user)
    {
        return xpGridUserMapper.insert(user);
    }

    public int delete(int sid)
    {
        return xpGridUserMapper.deleteByPrimaryKey(sid);
    }

    /** 更新信息 */
    public int edit(XpGridUser model)
    {
        return xpGridUserMapper.updateByPrimaryKeySelective(model);
    }

    /** 添加权限*/
    public int addUserAuthorization(XpGridUsersInRoles model)
    {
        return xpGridUsersInRolesMapper.insertSelective(model);
    }



}
