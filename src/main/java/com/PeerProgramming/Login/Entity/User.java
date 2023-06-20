package com.PeerProgramming.Login.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@zemosolabs\\.com$", message = "Email must end with zemosolabs.com")
    private String email;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$", message = "Invalid password")
    private String password;
}
