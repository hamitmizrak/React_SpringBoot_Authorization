package com.hamitmizrak.controller;


import com.hamitmizrak.data.repository.IRoleRepository;
import com.hamitmizrak.data.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// LOMBOK
@RequiredArgsConstructor

@RestController
public class AdminApi {

    // INJECTION
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

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
