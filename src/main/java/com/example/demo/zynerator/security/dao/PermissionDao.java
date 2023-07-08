package com.example.demo.zynerator.security.dao;

import com.example.demo.zynerator.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
