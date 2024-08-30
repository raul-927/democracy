package co.com.delibolis.products.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import co.com.delibolis.products.domain.enums.ProductType;
import java.sql.JDBCType;


public final class ProductDynamicSqlSupport {
    public static final Prod prd = new Prod();

    public static final SqlColumn<String> productId = prd.productId;
    public static final SqlColumn<String> productCode = prd.productCode;
    public static final SqlColumn<String> productName = prd.productName;
    public static final SqlColumn<String> productLastName = prd.productLastName;
    public static final SqlColumn<ProductType> productType = prd.productType;

    public static final class Prod extends SqlTable {
        public final SqlColumn<String> productId = column("product_id", JDBCType.LONGNVARCHAR);

        public final SqlColumn<String> productCode = column("product_code", JDBCType.LONGNVARCHAR);

        public final SqlColumn<String> productName = column("product_name", JDBCType.LONGNVARCHAR);

        public final SqlColumn<String> productLastName = column("last_name", JDBCType.LONGNVARCHAR);

        public final SqlColumn<ProductType> productType = column("product_type", JDBCType.LONGNVARCHAR);

        public Prod() {
            super("PRODUCT");
        }
    }


}
