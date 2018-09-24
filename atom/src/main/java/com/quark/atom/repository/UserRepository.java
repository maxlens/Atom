package com.quark.atom.repository;

import java.util.List;
import java.util.UUID;

import com.quark.atom.domain.User;

public interface UserRepository {

	void save(User user);
    void update(User user);
    User findOne(UUID uuid);
    void delete(UUID uuid);

    List<User> findAll();
    List<User> findUsersWithAuthLevel(String authLevel);
}
