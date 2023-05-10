package com.burakkutbay.springboot_security_example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

// LOMBOK
@Getter @Setter
@MappedSuperclass
public class BaseEntity {

    // user details için ekledim
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public BaseEntity() {
        this.isAccountNonExpired = false;
        this.isAccountNonLocked = false;
        this.isCredentialsNonExpired = false;
        this.isEnabled = false;
    }
}
