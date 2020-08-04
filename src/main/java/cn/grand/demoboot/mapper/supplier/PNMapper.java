package cn.grand.demoboot.mapper.supplier;

import cn.grand.demoboot.entity.supplier.PN;
import cn.grand.demoboot.entity.supplier.PNExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PNMapper {
    long countByExample(PNExample example);

    int deleteByExample(PNExample example);

    int deleteByPrimaryKey(String dnnum);

    int insert(PN record);

    int insertSelective(PN record);

    List<PN> selectByExample(PNExample example);

    PN selectByPrimaryKey(String dnnum);

    int updateByExampleSelective(@Param("record") PN record, @Param("example") PNExample example);

    int updateByExample(@Param("record") PN record, @Param("example") PNExample example);

    int updateByPrimaryKeySelective(PN record);

    int updateByPrimaryKey(PN record);
}