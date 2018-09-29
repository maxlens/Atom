package com.quark.atom.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.atom.domain.User;
import com.quark.atom.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        this.userRepository.save(user);
        return user;
}

	@Override
    public User update(User User) {
        User existingUser = this.userRepository.findOne(User.getId());
        if (existingUser != null) {
            this.userRepository.update(User);
        }
        return User;
    }

    @Override
    public User findOne(UUID uuid) {
        return this.userRepository.findOne(uuid);
    }

    @Override
    public void delete(UUID uuid) {
        User User = this.userRepository.findOne(uuid);
        if (User != null) {
            this.userRepository.delete(uuid);
        }
    }


	@Override
	public List<User> findUsersWithAuthLevel(String authLevel) {
		return this.userRepository.findUsersWithAuthLevel(authLevel);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
