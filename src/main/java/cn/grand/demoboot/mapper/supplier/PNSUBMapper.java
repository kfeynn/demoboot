package cn.grand.demoboot.mapper.supplier;

import cn.grand.demoboot.entity.supplier.PNSUB;
import cn.grand.demoboot.entity.supplier.PNSUBExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PNSUBMapper {
    long countByExample(PNSUBExample example);

    int deleteByExample(PNSUBExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PNSUB record);

    int insertSelective(PNSUB record);

    List<PNSUB> selectByExample(PNSUBExample example);

    PNSUB selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PNSUB record, @Param("example") PNSUBExample example);

    int updateByExample(@Param("record") PNSUB record, @Param("example") PNSUBExample example);

    int updateByPrimaryKeySelective(PNSUB record);

    int updateByPrimaryKey(PNSUB record);
}