package com.springframework.springcrud.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.logging.Level;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;


    public User toUser(){
        return new User(id,username,password,fullName,email);
    }
}
