package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Department;

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
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Collection;

public interface DepartmentDynamicMapper extends CommonSelectMapper{

    BasicColumn[] selectList = BasicColumn.columnList(departmentId, departmentName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.departmentId",keyColumn = "department_id")
    Mono<Integer> insert(InsertStatementProvider<Department> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.department",keyColumn = "department_id")
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
        return ReactiveMyBatis3Utils.countFrom(this::count, dep, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, dep, completer);
    }

    default Mono<Integer> insert(Department record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, dep, c ->
                c
                        .map(departmentId).toPropertyWhenPresent("departmentId", record::getDepartmentId)
                        .map(departmentName).toProperty("departmentName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Department> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, dep, c ->
                c
                        .map(departmentName).toProperty("departmentName")
        );
    }

    default Mono<Integer> insertSelective(Department record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, dep, c ->
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
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, selectList, dep, completer);
    }

    default Flux<Department> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, selectList, dep, completer);
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

    default Flux<Department> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, selectList, dep, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, dep, completer);
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
