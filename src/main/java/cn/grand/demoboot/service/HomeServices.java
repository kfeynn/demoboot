package cn.grand.demoboot.service;

import cn.grand.demoboot.entity.sqlserver.XpGridFunctions;
import cn.grand.demoboot.mapper.sqlserver.XpGridFunctionsMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServices
{
    // 可以用接口方式。实现类里写这些注解。controller里注入接口。然后调用就可以了。
    @Autowired
    XpGridFunctionsMapperPlus xpGridFunctionsMapper;

    public List<XpGridFunctions> selectListByUserId(int uid)
    {
        List<XpGridFunctions> list = xpGridFunctionsMapper.selectListByUserId(uid);
        return list;
    }
}
