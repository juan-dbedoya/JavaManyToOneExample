package com.spring.mysql.JavaOneToMany.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCredentials {
    private String email;
    private String password;


    public AuthCredentials() {

    }
}
