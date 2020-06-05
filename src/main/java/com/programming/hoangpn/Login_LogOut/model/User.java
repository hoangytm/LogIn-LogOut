package com.programming.hoangpn.Login_LogOut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
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
    //    private Instant created;
    @Column(name = "ENABLED")
    private boolean enabled;
}
