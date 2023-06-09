package com.hamitmizrak.data.repository;


import com.hamitmizrak.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByName(String userName);
    UserEntity findByEmail(String email);
}
