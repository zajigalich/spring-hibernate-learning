package com.my.dao;

import com.my.entity.Role;

public interface RoleDao {
    Role findRoleByName(String roleName);
}
