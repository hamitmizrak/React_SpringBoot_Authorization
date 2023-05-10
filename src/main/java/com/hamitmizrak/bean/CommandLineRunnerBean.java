package com.hamitmizrak.bean;

import com.hamitmizrak.data.entity.RoleEntity;
import com.hamitmizrak.data.entity.UserEntity;
import com.hamitmizrak.data.repository.IRoleRepository;
import com.hamitmizrak.data.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;


// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

@Configuration
public class CommandLineRunnerBean {

    // INJECTION
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    // Role sabit olmalı çünkü Spring Security böyle geliyor
    private final static String ROLE = "ROLE_";


    // proje ayağa kalkar kalmaz otomatik veri eklesin
    @Bean
    public CommandLineRunner projectDataProcess() { // parametre olarak verebilirsin==> ICustomerServices customerServices
        return args -> {
            RoleEntity roleAdmin = RoleEntity.builder().roleName(ROLE.concat("SUPER_ADMIN")).build();
            roleRepository.save(roleAdmin);
            List<RoleEntity> adminRoleList = new ArrayList<>();
            adminRoleList.add(roleAdmin);

            // admin
            UserEntity admin = new UserEntity();
            admin.setName("Hamit");
            admin.setSurname("Mizrak");
            admin.setName("admin");
            admin.setEmail("superadmin");
            admin.setPassword("1234");
            admin.setEnabled(true);
            admin.setAccountNonLocked(true);
            admin.setAccountNonExpired(true);
            admin.setCredentialsNonExpired(true);
            admin.setRoles(adminRoleList);
            userRepository.save(admin);

            System.out.println("-- Roles --");
            roleRepository.findAll().forEach(System.out::println);
            System.out.println("-- User --");
            userRepository.findAll().forEach(System.out::println);
        };
    }
}


/*
@Configuration
public class CommandLineRunnerBean {
    @Bean
    public CommandLineRunner projectDataProcess() { // parametre olarak verebilirsin==> ICustomerServices customerServices
        return args -> {
        };
    }
}*/

// 2.YOL
/*
@Component
public class CommandLineBean implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        }
    }
*/
