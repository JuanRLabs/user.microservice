package com.user.user.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String bornDate;
    private String password;
    @Column(unique = true, nullable = false, length = 20)
    private String dni;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity idRole;

}
