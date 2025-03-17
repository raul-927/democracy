package com.democracy.feingtarget.infrastructure.repository.mybatis.r2dbc.dynamic;

import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.where.WhereApplier;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Collection;


import com.democracy.feingtarget.domain.models.Product;
import static com.democracy.feingtarget.infrastructure.repository.mybatis.r2dbc.support.ProductDynamicSqlSupport.*;
public interface ProductDinamicMapper extends CommonSelectMapper {

    BasicColumn[] selectList = BasicColumn.columnList(productId, productCode,productName, productLastName, productType);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.productId",keyColumn = "product_id")
    Mono<Integer> insert(InsertStatementProvider<Product> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.productId",keyColumn = "product_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Product> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="ProductResult")
    Mono<Product> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="ProductResult")
    Flux<Product> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, prd, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, prd, completer);
    }

    default Mono<Integer> insert(Product record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, prd, c ->
                c
                        .map(productId).toPropertyWhenPresent("productId", record::getProductId)
                        .map(productCode).toProperty("productCode")
                        .map(productName).toProperty("productName")
                        .map(productLastName).toProperty("productLastName")
                        .map(productType).toProperty("productType")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Product> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, prd, c ->
                c
                        .map(productCode).toProperty("productCode")
                        .map(productName).toProperty("productName")
                        .map(productLastName).toProperty("productLastName")
                        .map(productType).toProperty("productType")
        );
    }

    default Mono<Integer> insertSelective(Product record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, prd, c ->
                c
                        .map(productId).toPropertyWhenPresent("productId", record::getProductId)
                        .map(productName).toPropertyWhenPresent("productName", record::getProductName)
                        .map(productCode).toPropertyWhenPresent("productCode", record::getProductCode)
                        .map(productLastName).toPropertyWhenPresent("job", record::getProductLastName)
                        .map(productType).toPropertyWhenPresent("manager", record::getProductType)
        );
    }

    default Mono<Product> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, selectList, prd, completer);
    }

    default Flux<Product> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, selectList, prd, completer);
    }
    default Flux<Product> selectProduct(Product product) {
        return select(prd ->{
            if(product.getProductId() != null ||
                    product.getProductCode() != null ||
                    product.getProductLastName() !=null ||
                    product.getProductName() != null ||
                    product.getProductType() !=null){
                if(product.getProductId()!=null && !product.getProductId().isEmpty()){
                    prd.where(productId,isEqualToWhenPresent(product.getProductId()));
                }else{
                    prd
                            .where(productCode,isLikeWhenPresent(product::getProductCode).map(s -> "%" + s + "%"))
                            .and(productName,isLikeWhenPresent(product::getProductName).map(s -> "%" + s + "%"))
                            .and(productLastName,isLikeWhenPresent(product::getProductLastName).map(s -> "%" + s + "%"))
                            .and(productType,isLikeWhenPresent(product::getProductType))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                prd.orderBy(productCode);
            }
            return prd;
        });
    }

    default Flux<Product> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, selectList, prd, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, prd, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Product record) {
        return update(c ->
            c
                    .set(productName).equalToWhenPresent(record::getProductName)
                    .set(productCode).equalToWhenPresent(record::getProductCode)
                    .set(productLastName).equalToWhenPresent(record::getProductLastName)
                    .set(productType).equalToWhenPresent(record::getProductType)
                    .where(productId, isEqualTo(record::getProductId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Product record) {
        return update(c ->
                c
                        .set(productName).equalToWhenPresent(record::getProductName)
                        .set(productLastName).equalTo(record::getProductLastName)
                        .set(productCode).equalTo(record::getProductCode)
                        .set(productType).equalTo(record::getProductType)
                        .where(productId, isEqualTo(record::getProductId))
        );
    }

    default Mono<Integer> updateAll(Product record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(productName).equalToWhenPresent(record::getProductName)
                        .set(productCode).equalToWhenPresent(record::getProductCode)
                        .set(productLastName).equalToWhenPresent(record::getProductLastName)
                        .set(productType).equalTo(record::getProductType)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Product record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(productName).equalToWhenPresent(record::getProductName)
                        .set(productCode).equalToWhenPresent(record::getProductCode)
                        .set(productLastName).equalToWhenPresent(record::getProductLastName)
                        .set(productType).equalToWhenPresent(record::getProductType)
                        .applyWhere(whereApplier)
        );
    }


}
