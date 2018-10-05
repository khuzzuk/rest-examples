package com.example.rest.user;

import java.util.List;

public interface UserRemoteService {
    List<User> getAll();
    void save(User user);
    User getByUsername(String username);
}
