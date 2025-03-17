package com.democracy.feingtarget.infrastructure.mappers;




import com.democracy.feingtarget.domain.models.Product;
import com.democracy.feingtarget.infrastructure.repository.mybatis.entitys.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @Mappings({
            @Mapping(source = "productId", 		    target = "productId"),
            @Mapping(source = "productCode",        target ="productCode"),
            @Mapping(source = "productName", 		target = "productName"),
            @Mapping(source = "productLastName",    target = "productLastName"),
            @Mapping(source = "productType",        target = "productType")
    })
    Product toProduct(ProductEntity productEntity);

    Iterable<Product> toProducts(Iterable<ProductEntity> productEntity);

    @InheritInverseConfiguration
    ProductEntity toProductEnity (Product product);
}
