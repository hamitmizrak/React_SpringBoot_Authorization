package com.hamitmizrak.bean;

import com.hamitmizrak.data.entity.RoleEntity;
import com.hamitmizrak.data.entity.UserEntity;
import com.hamitmizrak.data.repository.IRoleRepository;
import com.hamitmizrak.data.repository.IUserRepository;
import com.hamitmizrak.util.ERolesName;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

@Configuration
public class CustomerCommandLineRunner {

    // INJECTION
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;


    // Role sabit olmalı çünkü Spring Security böyle geliyor
    private final static String ROLE = "ROLE_";


    // proje ayağa kalkar kalmaz otomatik veri eklesin
    @Bean
    public CommandLineRunner projectDataProcess() { // parametre olarak verebilirsin==> ICustomerServices customerServices
        return args -> {
            //Role Tanımlama
            RoleEntity roleAdmin = RoleEntity.builder().role_name(ROLE.concat(ERolesName.ADMIN.toString())).build();
            RoleEntity roleUser = RoleEntity.builder().role_name(ROLE.concat(ERolesName.USER.toString())).build();
            RoleEntity roleWriter = RoleEntity.builder().role_name(ROLE.concat(ERolesName.WRITE.toString())).build();

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            roleRepository.save(roleWriter);

            List<RoleEntity> adminRoleList = new ArrayList<>();
            adminRoleList.add(roleAdmin);
            List<RoleEntity> userRoleList = new ArrayList<>();
            userRoleList.add(roleUser);
            List<RoleEntity> writerRoleList = new ArrayList<>();
            writerRoleList.add(roleWriter);


            // admin
            UserEntity admin = new UserEntity();
            //admin.setName("admin");
            admin.setEmail("admin");
            admin.setPassword("1234");
            admin.setEnabled(true);
            admin.setAccountNonLocked(true);
            admin.setAccountNonExpired(true);
            admin.setCredentialsNonExpired(true);
            admin.setRoles(adminRoleList);
            userRepository.save(admin);

            // user
            UserEntity user = new UserEntity();
            //user.setName("user");
            user.setEmail("user");
            user.setPassword("1234");
            user.setEnabled(true);
            user.setAccountNonLocked(true);
            user.setAccountNonExpired(true);
            user.setCredentialsNonExpired(true);
            user.setRoles(userRoleList);
            userRepository.save(user);

            // write
            UserEntity write = new UserEntity();
            //write.setName("write");
            write.setEmail("write");
            write.setPassword("1234");
            write.setEnabled(true);
            write.setAccountNonLocked(true);
            write.setAccountNonExpired(true);
            write.setCredentialsNonExpired(true);
            write.setRoles(writerRoleList);
            userRepository.save(write);

            System.out.println("-- Roles --");
            roleRepository.findAll().forEach(System.out::println);
            System.out.println("-- User --");
            userRepository.findAll().forEach(System.out::println);
        };
    }
}


// 2.YOL
/*@Component
public class CommandLineBean implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}*/

