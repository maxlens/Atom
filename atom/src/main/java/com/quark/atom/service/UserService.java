package com.quark.atom.service;

import java.util.List;
import java.util.UUID;

import com.quark.atom.domain.User;

public interface UserService {

    User save(User user);
    User update(User user);
    User findOne(UUID uuid);
    void delete(UUID uuid);

    List<User> findAll();
    List<User> findUsersWithAuthLevel(String authLevel);

}
