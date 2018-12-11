package com.pinnet.transaction.impl;

import com.pinnet.transaction.ITransactionUserService;
import com.pinnet.transaction.TransactionUser;
import com.pinnet.transaction.mapper.TransactionUserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TransactionUserServiceImpl implements ITransactionUserService {

    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(TransactionUser transactionUser) {
        jdbcTemplate.update("INSERT INTO transaction_user (name, age) VALUES (?,?)",
                new Object[] {transactionUser.getName(), transactionUser.getAge()});
        throw new RuntimeException("test");
    }

    public TransactionUser getTransactionUser(Long id) {
        TransactionUser transactionUser =
                jdbcTemplate.queryForObject("select * from transaction_user where id=?", new Object[]{id}, new TransactionUserMapper());
        return transactionUser;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
