package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "admin")
// @Component
// @Where(clause = "roles_id = 1")
// N(User) M(Roles)
public class AdminEntity extends BaseEntity{

    @Id
    @Order(value = 1)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private long id;

    private String name;
    private String surname;
    private String email;
    private String password;

    // @Embedded
    // @Embeddable
    // @EmbeddedId

    // 1 .YOL Relation
    /*
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "admin_id",referencedColumnName = "admin_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id",referencedColumnName = "roles_id")}
    )
    private List<RoleEntity> roles;
    */

    // 2.YOL Relation
    //@OrderBy
    //@OrderBy("rolesId DESC")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "admin_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Collection<RoleEntity> roles;

}
