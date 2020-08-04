package cn.grand.demoboot.mapper.supplier;

import cn.grand.demoboot.entity.supplier.SupplierLogin;
import cn.grand.demoboot.entity.supplier.SupplierLoginExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierLoginMapper {
    long countByExample(SupplierLoginExample example);

    int deleteByExample(SupplierLoginExample example);

    int deleteByPrimaryKey(String id);

    int insert(SupplierLogin record);

    int insertSelective(SupplierLogin record);

    List<SupplierLogin> selectByExample(SupplierLoginExample example);

    SupplierLogin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SupplierLogin record, @Param("example") SupplierLoginExample example);

    int updateByExample(@Param("record") SupplierLogin record, @Param("example") SupplierLoginExample example);

    int updateByPrimaryKeySelective(SupplierLogin record);

    int updateByPrimaryKey(SupplierLogin record);
}