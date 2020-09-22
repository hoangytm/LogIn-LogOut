package com.programming.hoangpn.Login_LogOut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long userId;
    @NotBlank(message = "Username is required")
    @Column(name = "USER_NAME")
    private String username;
    @NotBlank(message = "Password is required")
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
}
