package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.Department;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport;
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
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Collection;

public interface DepartmentDynamicMapper extends CommonSelectMapper{

    BasicColumn[] departmentColumnList = BasicColumn.columnList(departmentId, departmentName);
    BasicColumn[] departmentCityColumnList = BasicColumn.columnList(departmentId, departmentName, cityId, cityName);
    BasicColumn[] departmentCitytNeighborhoodStreetColumnList = BasicColumn.columnList(
            departmentId, departmentName,
            cityId, cityName,
            neighborhoodId, neighborhoodName,
            streetId, streetName, streetType);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.departmentId",keyColumn = "department_id")
    Mono<Integer> insert(InsertStatementProvider<Department> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.departmentId",keyColumn = "department_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Department> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DepartmentResult")
    Mono<Department> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DepartmentResult")
    Flux<Department> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, DEPARTMENT, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, DEPARTMENT, completer);
    }

    default Mono<Integer> insert(Department record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DEPARTMENT, c ->
                c
                        .map(departmentId).toPropertyWhenPresent("departmentId", record::getDepartmentId)
                        .map(departmentName).toProperty("departmentName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Department> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, DEPARTMENT, c ->
                c
                        .map(departmentName).toProperty("departmentName")
        );
    }

    default Mono<Integer> insertSelective(Department record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DEPARTMENT, c ->
                c
                        .map(departmentName).toPropertyWhenPresent("departmentName", record::getDepartmentName)

        );
    }

    default Mono<Integer> deleteDepartment(String id){
        return this.delete(
                d -> d.where(DepartmentDynamicSqlSupport.departmentId, isEqualTo(id))
        );
    }

    default Mono<Department> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, departmentColumnList, DEPARTMENT, completer);
    }

    default Flux<Department> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, departmentColumnList, DEPARTMENT, completer);
    }

    default Flux<Department> selectFullColumnDepartment(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, departmentCitytNeighborhoodStreetColumnList, DEPARTMENT, completer);
    }
    default Flux<Department> selectAllDepartment(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, departmentColumnList, DEPARTMENT, completer);
    }
    default Flux<Department> selectDepartment(Department department) {
        return select(str ->{
            if(department.getDepartmentId() != null ||
                    department.getDepartmentName() != null){
                if(department.getDepartmentId()!=null && !department.getDepartmentId().isEmpty()){
                    str.where(departmentId,isEqualToWhenPresent(department.getDepartmentId()));
                }else{
                    str
                            .where(departmentName,isLikeWhenPresent(department::getDepartmentName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(departmentId);
            }
            return str;
        });
    }
    default Flux<Department> selectFullDepartment(Department department) {
        BindableColumn<Department> DEPARTMENT_department_id= DerivedColumn.of("department_id", "DEPARTMENT");
        BindableColumn<Department> DEPARTMENT_CITY_department_id= DerivedColumn.of("department_id", "DEPARTMENT_CITY");
        BindableColumn<Department> DEPARTMENT_CITY_city_id= DerivedColumn.of("city_id", "DEPARTMENT_CITY");

        BindableColumn<Department> CITY_city_id= DerivedColumn.of("city_id", "CITY");
        BindableColumn<Department> CITY_NEIGH_city_id = DerivedColumn.of("city_id", "CITY_NEIGH");
        BindableColumn<Department> CITY_NEIGH_neigyborhood_id = DerivedColumn.of("neighborhood_id", "CITY_NEIGH");

        BindableColumn<Department> NEIGHBORHOOD_neighborhood_id = DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");

        BindableColumn<Department> NEIGH_STREET_neighborhood_id = DerivedColumn.of("neighborhood_id", "NEIGH_STREET");
        BindableColumn<Department> NEIGH_STREET_street_id = DerivedColumn.of("street_id", "NEIGH_STREET");
        BindableColumn<Department> STREET_street_id = DerivedColumn.of("street_id", "STREET");


        return selectFullColumnDepartment(str ->{
           str
                    .join(DepartmentCityDynamicSqlSupport.DEPARTMENT_CITY)
                    .on(DEPARTMENT_department_id, equalTo(DEPARTMENT_CITY_department_id))

                    .join(CityDynamicSqlSupport.CITY)
                    .on(DEPARTMENT_CITY_city_id,equalTo(CITY_city_id))

                    .join(CityNeighDynamicSqlSupport.CITY_NEIGH)
                    .on(CITY_city_id,equalTo(CITY_NEIGH_city_id))

                    .join(NeighborhoodDynamicSqlSupport.NEIGHBORHOOD)
                    .on(CITY_NEIGH_neigyborhood_id,equalTo(NEIGHBORHOOD_neighborhood_id))

                    .join(NeighborhoodStreetDynamicSqlSupport.NEIGH_STREET)
                    .on(NEIGHBORHOOD_neighborhood_id,equalTo(NEIGH_STREET_neighborhood_id))

                    .join(StreetDynamicSqlSupport.STREET)
                    .on(NEIGH_STREET_street_id,equalTo(STREET_street_id)).build();


            if(department.getDepartmentId() != null ||
                    department.getDepartmentName() != null){
                if(department.getDepartmentId()!=null && !department.getDepartmentId().isEmpty()){
                    str.where(departmentId,isEqualToWhenPresent(department.getDepartmentId()));
                }else{
                    str
                            .where(departmentName,isLikeWhenPresent(department::getDepartmentName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(departmentName);
            }
            return str;
        });
    }

    default Flux<Department> selectAllDepartment(){
        return selectAllDepartment( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Department> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, departmentColumnList, DEPARTMENT, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, DEPARTMENT, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Department record) {
        return update(c ->
                c
                        .set(departmentName).equalToWhenPresent(record::getDepartmentName)

                        .where(departmentId, isEqualTo(record::getDepartmentId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Department record) {
        return update(c ->
                c
                        .set(departmentName).equalToWhenPresent(record::getDepartmentName)
                        .where(departmentId, isEqualTo(record::getDepartmentId))
        );
    }

    default Mono<Integer> updateAll(Department record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(departmentName).equalToWhenPresent(record::getDepartmentName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Department record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(departmentName).equalToWhenPresent(record::getDepartmentName)
                        .applyWhere(whereApplier)
        );
    }
}
