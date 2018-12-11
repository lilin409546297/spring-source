package com.pinnet.jdbc.impl;

import com.pinnet.jdbc.IRoleService;
import com.pinnet.jdbc.Role;
import com.pinnet.jdbc.RoleMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Funtion: TODO.
 * <p>
 * Author: lWX559685
 * Date: 2018/7/4 13:58
 */
public class RoleServiceImpl implements IRoleService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSoure(DataSource dataSoure) {
        jdbcTemplate = new JdbcTemplate(dataSoure);
    }

    public Role save(Role role) {
        jdbcTemplate.update("insert INTO role (name, detail) VALUES (?,?)", new Object[]{ role.getName(), role.getDetail()});
        return role;
    }

    public List<Role> getAll() {
        List<Role> roles = jdbcTemplate.query("select * from role", new RoleMapper());
        return roles;
    }
}
