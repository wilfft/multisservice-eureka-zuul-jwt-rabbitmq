package com.example.authentication.jwt;

import com.example.authentication.entity.Login;
import com.example.authentication.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    LoginRepository repository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String email = authentication.getName();
        // You can get the password here
        String password = authentication.getCredentials().toString();
        Optional<Login> loginOptional = repository.findByEmailAndPassword(email, password);
        if (loginOptional.isPresent()) {
            System.out.println("Enconrou");
            return new UsernamePasswordAuthenticationToken(email, password);
        }
        // Your custom authentication logic here
     /*   if (name.equals("admin") && password.equals("pwd")) {
            Authentication auth = new UsernamePasswordAuthenticationToken(name,
                    password);

            return auth;
        }*/

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
