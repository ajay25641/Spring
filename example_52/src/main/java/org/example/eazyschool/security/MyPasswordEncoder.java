package org.example.eazyschool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean verifyPassword(String password,String hashPassword){
        return passwordEncoder.matches(password,hashPassword);
    }

    public String generatePassword(String password){
        return passwordEncoder.encode(password);
    }


}
