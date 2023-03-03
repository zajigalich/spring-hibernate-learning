package com.my.service.impl;

import com.my.dao.RoleDao;
import com.my.entity.Role;
import com.my.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional("securityTransactionManager")
    public Map<String, String> getStringRoles() {
        List<Role> roles = roleDao.getRoles().stream().toList();

        return roles.stream().collect(
                Collectors.toMap(
                        Role::getName,
                        role -> StringUtils.capitalize(role.getName().replaceAll("ROLE_", "").toLowerCase())));

    }
}
