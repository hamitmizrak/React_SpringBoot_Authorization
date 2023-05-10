package com.hamitmizrak.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RoleDto {
    private Long rolesId;
    private String roleName;
}
