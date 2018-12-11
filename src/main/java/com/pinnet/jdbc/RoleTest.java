package com.pinnet.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RoleTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        IRoleService roleService = (IRoleService) context.getBean("roleService");
        Role role = new Role();
        role.setName("test");
        role.setDetail("detail");
        roleService.save(role);
        System.out.println(role);
        List<Role> roles = roleService.getAll();
        System.out.println(roles);
    }
}
