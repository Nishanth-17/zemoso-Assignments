package com.example.springsecuritylogin.Repository;

import com.example.springsecuritylogin.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
