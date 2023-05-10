package com.hamitmizrak.security;

import com.hamitmizrak.data.entity.UserEntity;
import com.hamitmizrak.data.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// LOMBOK
@RequiredArgsConstructor

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // INJECTION
   private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // UserEntity user = userRepository.findByName(name);
        UserEntity emailData = userRepository.findByEmail(email);
        return new CustomUserDetail(emailData);
    }
}
