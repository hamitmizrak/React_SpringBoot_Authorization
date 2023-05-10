package com.burakkutbay.springboot_security_example.repository;

import com.burakkutbay.springboot_security_example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByName(String userName);
    UserEntity findByEmail(String email);
}
