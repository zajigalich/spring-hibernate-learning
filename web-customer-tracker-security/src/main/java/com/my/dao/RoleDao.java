package com.my.dao;

import com.my.entity.Role;

import java.util.Collection;

public interface RoleDao {
    Role findRoleByName(String roleName);

    Collection<Role> getRoles();
}
