package com.democracy.person.mybatis.mappers;

import com.democracy.person.domain.ChallengeAttempt;
import com.democracy.person.domain.User;
import com.democracy.person.mybatis.sql.UserSqlProvider;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserMapper {
    @InsertProvider(type = UserSqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "auser_id")
    User insert(@Param("user") User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    User update(@Param("user") User user);

    @SelectProvider(type = UserSqlProvider.class, method = "select")
    @ResultMap("com.democracy.person.mybatis.mappers.UserMapper.UserResult")
    Optional<User> select(@Param("user") User user);
}
