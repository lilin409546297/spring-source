package com.pinnet.transaction.mapper;

import com.pinnet.transaction.TransactionUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionUserMapper implements RowMapper<TransactionUser> {

    public TransactionUser mapRow(ResultSet resultSet, int i) throws SQLException {
        TransactionUser transactionUser = new TransactionUser();
        transactionUser.setId(resultSet.getLong("id"));
        transactionUser.setName(resultSet.getString("name"));
        transactionUser.setAge(resultSet.getString("age"));
        return transactionUser;
    }
}
