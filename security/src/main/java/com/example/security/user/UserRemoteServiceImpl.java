package com.example.security.user;

import com.example.security.security.Catch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class UserRemoteServiceImpl implements UserRemoteService {
    private static final String USER_SERVICE_URL = "http://localhost:8080/users/user/";

    private RestTemplate restTemplate;

    @Override
    @Catch
    public User getUser(String username) {
        return restTemplate.getForObject(USER_SERVICE_URL + username, com.example.security.user.User.class);
    }
}
