package com.democracy.person.mybatis.mappers;

import com.democracy.person.domain.ChallengeAttempt;
import com.democracy.person.mybatis.sql.ChallengeAttemptSqlProvider;
import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface ChallengeAttemptMapper {
    @InsertProvider(type = ChallengeAttemptSqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "addressId", keyColumn = "address_id")
    ChallengeAttempt insert(@Param("challengeAttempt") ChallengeAttempt challengeAttempt);

    @UpdateProvider(type = ChallengeAttemptSqlProvider.class, method = "update")
    ChallengeAttempt update(@Param("challengeAttempt") ChallengeAttempt challengeAttempt);

    @SelectProvider(type = ChallengeAttemptSqlProvider.class, method = "select")
    @ResultMap("com.democracy.person.mybatis.mappers.ChallengeAttemptMapper.ChallengeAttemptResult")
    List<ChallengeAttempt> select(@Param("challengeAttempt") ChallengeAttempt challengeAttempt);
}
