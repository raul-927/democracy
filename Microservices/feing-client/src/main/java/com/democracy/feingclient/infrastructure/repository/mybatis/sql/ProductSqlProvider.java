package com.democracy.feingclient.infrastructure.repository.mybatis.sql;

import com.democracy.feingclient.infrastructure.repository.mybatis.entitys.ProductEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {


    public String insert(ProductEntity product){
        SQL sql = new SQL(){{
            INSERT_INTO("PRODUCT");
            if(product.getProductName()!= null && !product.getProductName().isEmpty()){
                VALUES("product_name", "'".concat(product.getProductName()).concat("'"));
            }
            if(product.getProductName()!=null && !product.getProductLastName().isEmpty()){
                VALUES("last_name", "'".concat(product.getProductLastName()).concat("'"));
            }
            VALUES("product_type", "'".concat(product.getProductType().name()).concat("'"));
        }};

        System.out.println("INSERT RESULT: "+sql.toString());
        return sql.toString();
    }


    public String select(@Param("product")ProductEntity product){
        SQL sql = new SQL(){{
            SELECT("product_id, product_name, last_name, product_type");
            FROM("PRODUCT");
            if(product.getProductId() != null && !product.getProductId().isEmpty()){
                WHERE("product_id = "+"'".concat(product.getProductId()).concat("'"));
            }else {
                if(product.getProductName() != null && !product.getProductName().isEmpty()){
                    WHERE("product_name = "+"'".concat(product.getProductName()).concat("'"));
                }
                if(product.getProductLastName() != null && !product.getProductLastName().isEmpty()){
                    WHERE("last_name = "+"'".concat(product.getProductLastName()).concat("'"));
                }
                if(product.getProductType()!= null){
                    WHERE("product_type = "+"'".concat(product.getProductType().name()).concat("'"));
                }
            }
        }};
        System.out.println("SELECT RESULT: "+sql.toString());
        return sql.toString();
    }
    public String selectCount(){
        return new SQL(){{
            SELECT("count(1)");
            FROM("PRODUCT");
        }}.toString();
    }

}
