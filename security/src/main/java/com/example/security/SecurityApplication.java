package com.example.security;

import com.example.security.role.Role;
import com.example.security.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDb(PasswordEncoder encoder, RestTemplate restTemplate) {
        return args -> {
            String password = encoder.encode("admin");
            User user = new User();
            user.setUsername("admin");
            user.setPassword(password);

            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            user.setRoles(Collections.singleton(adminRole));

            restTemplate.put("http://localhost:8080/users/registerAdmin", user);

            User admin = restTemplate.getForObject("http://localhost:8080/users/user/admin", User.class);
            System.out.println(admin);
        };
    }
}
