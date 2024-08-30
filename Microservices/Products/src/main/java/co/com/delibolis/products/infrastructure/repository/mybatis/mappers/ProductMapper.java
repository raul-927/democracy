package co.com.delibolis.products.infrastructure.repository.mybatis.mappers;

import co.com.delibolis.products.infrastructure.repository.mybatis.entitys.ProductEntity;
import co.com.delibolis.products.infrastructure.repository.mybatis.sql.ProductSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {


    //@InsertProvider(type = ProductSqlProvider.class, method ="insert")
    //@Options(useGeneratedKeys=true, keyProperty="productId", keyColumn = "product_id")
    void insert(@Param("product") ProductEntity product);


    //@SelectProvider(type = ProductSqlProvider.class, method = "select")
    //@ResultMap("co.com.delibolis.products.infrastructure.repository.mybatis.mappers.ProductMapper.ProductResult")
    List<ProductEntity> select(@Param("product")ProductEntity product);

    //@SelectProvider(type = ProductSqlProvider.class, method = "selectCount")
    //@ResultMap("co.com.delibolis.products.infrastructure.repository.mybatis.mappers.ProductMapper.ProductResult")
    Integer selectCount();
}
