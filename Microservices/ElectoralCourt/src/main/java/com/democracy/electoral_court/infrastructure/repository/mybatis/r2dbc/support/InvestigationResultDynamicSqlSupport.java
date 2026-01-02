package com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import java.sql.JDBCType;

public final class InvestigationResultDynamicSqlSupport {

    public static final InvestigationResult INVESTIGATION_RESULT = new InvestigationResult();

    public static final SqlColumn<String> investigationResultId = INVESTIGATION_RESULT.investigationResultId;
    public static final SqlColumn<String> investigationId = INVESTIGATION_RESULT.investigationId;
    public static final SqlColumn<Integer> cedula        = INVESTIGATION_RESULT.cedula;
    public static final SqlColumn<String> personId        = INVESTIGATION_RESULT.personId;
    public static final SqlColumn<String> observation     = INVESTIGATION_RESULT.observation;
    public static final SqlColumn<String> score     = INVESTIGATION_RESULT.score;
    public static final SqlColumn<String> isApprove     = INVESTIGATION_RESULT.isApprove;

    public static final class InvestigationResult extends SqlTable {
        public final SqlColumn<String> investigationResultId = column("investigation_result_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> investigationId = column("investigation_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Integer> cedula        = column("cedula", JDBCType.INTEGER);
        public final SqlColumn<String> personId        = column("person_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> observation     = column("observation", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> score     = column("score", JDBCType.BOOLEAN);
        public final SqlColumn<String> isApprove     = column("is_approve", JDBCType.BOOLEAN);

        public InvestigationResult(){
            super("INVESTIGATION_RESULT");
        }
    }
}
