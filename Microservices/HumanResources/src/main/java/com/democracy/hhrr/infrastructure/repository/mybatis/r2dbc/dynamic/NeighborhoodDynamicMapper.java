package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.DerivedColumn;
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
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface NeighborhoodDynamicMapper extends CommonSelectMapper{

    BasicColumn[] selectList = BasicColumn.columnList(neighborhoodId, neighborhoodName, departmentId, departmentName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.neighborhoodId",keyColumn = "neighborhood_id")
    Mono<Integer> insert(InsertStatementProvider<Neighborhood> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.neighborhoodId",keyColumn = "neighborhood_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Neighborhood> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="NeighborhoodResult")
    Mono<Neighborhood> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="NeighborhoodResult")
    Flux<Neighborhood> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, neigh, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, neigh, completer);
    }

    default Mono<Integer> insert(Neighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neigh, c ->
                c
                        .map(neighborhoodName).toProperty("neighborhoodName")
                        .map(departmentId).toPropertyWhenPresent("department.departmentId", record.getDepartment()::getDepartmentId)
        );
    }

    default Mono<Integer> insertMultiple(Collection<Neighborhood> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, neigh, c ->
                c
                        .map(neighborhoodName).toProperty("neighborhoodName")
                        .map(departmentId).toProperty("department.departmentId")
        );
    }

    default Mono<Integer> insertSelective(Neighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neigh, c ->
                c
                        .map(neighborhoodName).toPropertyWhenPresent("neighborhoodName", record::getNeighborhoodName)
                        .map(departmentId).toPropertyWhenPresent("department.departmentId", record.getDepartment()::getDepartmentId)

        );
    }

    default Mono<Integer> deleteNeighborhood(String id){
        return this.delete(
                d -> d.where(NeighborhoodDynamicSqlSupport.neighborhoodId, isEqualTo(id))
        );
    }

    default Mono<Neighborhood> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, selectList, neigh, completer);
    }

    default Flux<Neighborhood> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, selectList, neigh, completer);
    }
    default Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood) {
        BindableColumn<Neighborhood> joinDepartmentColumn = DerivedColumn.of("department_id", "DEPARTMENT");
        BindableColumn<Neighborhood> joinNeighborhoodColumn = DerivedColumn.of("department_id", "NEIGHBORHOOD");
        return select(str ->{
            str.join(DepartmentDynamicSqlSupport.dep)
                    .on(joinNeighborhoodColumn,equalTo(joinDepartmentColumn)).build();
            if(neighborhood.getNeighborhoodId() != null ||
                    neighborhood.getNeighborhoodName() != null ||
            neighborhood.getDepartment() != null){
                if(neighborhood.getNeighborhoodId()!=null && !neighborhood.getNeighborhoodId().isEmpty()){
                    str.where(neighborhoodId,isEqualToWhenPresent(neighborhood.getNeighborhoodId()));
                }else{
                    str
                            .where(neighborhoodName,isLikeWhenPresent(neighborhood::getNeighborhoodName).map(s -> "%" + s + "%"))
                            .and(departmentName,isLikeWhenPresent(neighborhood.getDepartment()::getDepartmentName).map(s -> "%" + s + "%"))
                            .and(departmentId, isEqualTo(neighborhood.getDepartment()::getDepartmentId))

                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(neighborhoodId);
            }
            return str;
        });
    }

    default Flux<Neighborhood> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, selectList, neigh, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, neigh, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Neighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .set(departmentId).equalToWhenPresent(record.getDepartment()::getDepartmentId)

                        .where(neighborhoodId, isEqualTo(record::getNeighborhoodId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Neighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .where(neighborhoodId, isEqualTo(record::getNeighborhoodName))
        );
    }

    default Mono<Integer> updateAll(Neighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .set(departmentId).equalToWhenPresent(record.getDepartment()::getDepartmentId)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Neighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .set(departmentId).equalToWhenPresent(record.getDepartment()::getDepartmentId)
                        .applyWhere(whereApplier)
        );
    }
}
