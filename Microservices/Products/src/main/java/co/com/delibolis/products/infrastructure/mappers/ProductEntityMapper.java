package co.com.delibolis.products.infrastructure.mappers;




import co.com.delibolis.products.domain.models.Product;
import co.com.delibolis.products.infrastructure.repository.mybatis.entitys.ProductEntity;
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
