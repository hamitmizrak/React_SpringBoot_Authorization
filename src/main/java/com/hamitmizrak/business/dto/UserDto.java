package com.hamitmizrak.business.dto;

import com.hamitmizrak.data.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Collection<RoleEntity> roles;
}
