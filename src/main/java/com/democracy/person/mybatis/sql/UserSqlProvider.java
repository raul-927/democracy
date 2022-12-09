package com.democracy.person.mybatis.sql;

import com.democracy.person.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insert(User user) {
        return new SQL() {
            {}
        }
            .toString();
    }

    public String update(User user) {
        return new SQL() {
            {}
        }
            .toString();
    }

    public String delete(User user) {
        return new SQL() {
            {}
        }
            .toString();
    }

    public String select(User user) {
        return new SQL() {
            {}
        }
            .toString();
    }
}
