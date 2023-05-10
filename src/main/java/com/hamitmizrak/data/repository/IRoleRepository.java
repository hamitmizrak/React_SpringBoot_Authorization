package com.burakkutbay.springboot_security_example.repository;

import com.burakkutbay.springboot_security_example.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
}
