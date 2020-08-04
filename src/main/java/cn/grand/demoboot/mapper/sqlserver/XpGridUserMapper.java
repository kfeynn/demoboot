package cn.grand.demoboot.mapper.sqlserver;

import cn.grand.demoboot.entity.sqlserver.XpGridUser;
import cn.grand.demoboot.entity.sqlserver.XpGridUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface XpGridUserMapper {
    long countByExample(XpGridUserExample example);

    int deleteByExample(XpGridUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(XpGridUser record);

    int insertSelective(XpGridUser record);

    List<XpGridUser> selectByExample(XpGridUserExample example);

    XpGridUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") XpGridUser record, @Param("example") XpGridUserExample example);

    int updateByExample(@Param("record") XpGridUser record, @Param("example") XpGridUserExample example);

    int updateByPrimaryKeySelective(XpGridUser record);

    int updateByPrimaryKey(XpGridUser record);
}