package com.hamitmizrak.controller;

import com.hamitmizrak.data.entity.RoleEntity;
import com.hamitmizrak.data.entity.UserEntity;
import com.hamitmizrak.data.repository.IRoleRepository;
import com.hamitmizrak.data.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class UserApi {

    // INJECTION
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    private final static String ROLE = "ROLE_";

    // localhost:2222/api/roles
    @PostMapping("api/roles")
    public ResponseEntity<RoleEntity> getRoles(@RequestBody RoleEntity roleEntity){
        roleEntity.setRoleName(ROLE.concat(roleEntity.getRoleName()));
        RoleEntity roleEntityData=roleRepository.save(roleEntity);
        return ResponseEntity.ok(roleEntityData);
    }

    // localhost:2222/api/user/1
    @PostMapping("api/user/{path_id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable(name="path_id") Integer rolesId, @RequestBody UserEntity userEntity){
        RoleEntity roleEntity= roleRepository.findAll().get((rolesId-1));
        List<RoleEntity> rolList=new ArrayList<>();
        rolList.add(roleEntity);
        userEntity.setRoles(rolList);
        //User details
        userEntity.setEnabled(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setAccountNonExpired(true);
        userEntity.setCredentialsNonExpired(true);
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }


    // localhost:2222/api/user/list
    @GetMapping("api/user/list")
    public List<UserEntity> getDeneme(){
        System.out.println("-- Roles --");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("-- User --");
        userRepository.findAll().forEach(System.out::println);
        return userRepository.findAll();
    }

    // http://localhost:2222/h2-console
    // http://localhost:2222/swagger-ui.html

    // http://localhost:2222/just_super_admin_page
    @GetMapping("/just_super_admin_page")
    public String superAdmin(){
        return "SPECIAL SUPERADMIN özel mesajdır";
    }

    // http://localhost:2222/just_admin_page
    @GetMapping("/just_admin_page")
    public String admin(){
        return "SPECIAL SUPERADMIN VE ADMIN özel mesajdır";
    }

    // http://localhost:2222/alllogin
    @GetMapping("/alllogin")
    public String  loginDashboard() {
        return "ÜYE GİRİŞ YAPMIŞ ADMIN,USER,WRITE";
    }

    // http://localhost:2222/just_user_page
    @GetMapping("/just_user_page")
    public String  userDashboard() {
        return "ÜYE GİRİŞ YAPMIŞ USER,ADMIN,SUPERADMIN";
    }

    // http://localhost:2222/just_write_page
    @GetMapping("/just_write_page")
    public String  writeDashboard() {
        return "ÜYE GİRİŞ YAPMIŞ WRITE,ADMIN,SUPERADMIN";
    }

    // http://localhost:2222/index
    @GetMapping("/index")
    public String index(){
        return "GENEL Ana sayfa";
    }

    // http://localhost:2222/
    @GetMapping("/")
    public String indexHome(){
        return "GENEL Ana sayfa";
    }
}
