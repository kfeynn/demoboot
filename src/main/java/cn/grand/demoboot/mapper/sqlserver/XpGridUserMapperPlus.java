package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
//@Mapper
@Repository
public interface XpGridUserMapperPlus
{
    //多个参数，用注入的方式传入
    int isExists(@Param("username") String username, @Param("password") String password);

    XpGridUser selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

}