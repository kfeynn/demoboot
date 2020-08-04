package cn.grand.demoboot.dao;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctionsForPublic;
import cn.grand.demoboot.mapper.sqlserver.XpGridFunctionsForPublicMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class XpGridFunctionsForPublicDao
{
    @Autowired
    XpGridFunctionsForPublicMapperPlus xpGridFunctionsForPublicMapper;

    public List<XpGridFunctionsForPublic> selectList()
    {
        return xpGridFunctionsForPublicMapper.selectListByUserId();
    }

}
