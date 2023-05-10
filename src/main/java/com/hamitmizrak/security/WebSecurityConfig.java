package com.hamitmizrak.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// LOMBOK
@RequiredArgsConstructor

// Web Security
@EnableWebSecurity
@Configuration
public class SecurityConfiguration{

    //INJECTION
   private UserDetailsService userDetailsService;

    @Bean
    //@SneakyThrows // throws Exception
    protected void configure(HttpSecurity http) throws Exception {
        /*http.httpBasic();
        http.formLogin();*/

        http
                .authorizeRequests()
                .requestMatchers("/alllogin").hasAnyRole("SUPER_ADMIN","ADMIN", "USER", "WRITE")
                .requestMatchers("/just_super_admin_page").hasRole("SUPER_ADMIN") //sadece superAdmin Girebilir
                .requestMatchers("/just_admin_page").hasAnyRole("ADMIN","SUPER_ADMIN") // admin ve superAdmin girebilir.
                .requestMatchers("/just_user_page").hasAnyRole("USER", "ADMIN","SUPER_ADMIN")
                .requestMatchers("/just_write_page").hasAnyRole("WRITE", "ADMIN","SUPER_ADMIN")
                .requestMatchers("/h2-console/**").hasAnyRole("ADMIN","SUPER_ADMIN")
                //.antMatchers("/h2-console/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/index").permitAll();

        // H2-console için yazdım
        http.csrf().disable();
        // H2-console içindeki labelleri açmak için
        http.headers().frameOptions().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }
}

/*
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    @Order(1)
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.formLogin();
        http.authorizeHttpRequests()
                .antMatchers("/alllogin").hasAnyRole("SUPER_ADMIN","ADMIN", "USER", "WRITE")
                .antMatchers("/just_super_admin_page").hasRole("SUPER_ADMIN") //sadece superAdmin Girebilir
                .antMatchers("/just_admin_page").hasAnyRole("ADMIN","SUPER_ADMIN") // admin ve superAdmin girebilir.
                .antMatchers("/just_user_page").hasAnyRole("USER", "ADMIN","SUPER_ADMIN")
                .antMatchers("/just_write_page").hasAnyRole("WRITE", "ADMIN","SUPER_ADMIN")
                .antMatchers("/h2-console/**").hasAnyRole("ADMIN","SUPER_ADMIN")
                //.antMatchers("/h2-console/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/index")
                .permitAll();

        // H2-console için yazdım
        http.csrf().disable();
        // H2-console içindeki labelleri açmak için
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    //Deprecated olan bir metot ve artık kullanmamıza gerek yok noop derken yetiyor.
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
*/
