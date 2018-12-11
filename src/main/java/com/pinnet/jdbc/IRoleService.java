package com.pinnet.jdbc;

import java.util.List;

/**
 * Funtion: TODO.
 * <p>
 * Author: lWX559685
 * Date: 2018/7/4 13:57
 */
public interface IRoleService {

    Role save(Role role);
    List<Role> getAll();
}
