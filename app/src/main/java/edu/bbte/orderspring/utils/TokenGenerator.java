package edu.bbte.orderspring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
    @Autowired
    private  PasswordEncoder passwordEncoder;
    public  String SECRET = "ThisisMySecretKey";

    public String generateToken() {
        try {
            return passwordEncoder.encode(SECRET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkToken(String token) {
        try {
            return passwordEncoder.validatePassword(SECRET, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
