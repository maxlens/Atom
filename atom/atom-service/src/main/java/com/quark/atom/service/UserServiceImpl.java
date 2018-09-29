package com.quark.atom.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.atom.cassandra.domain.User;
import com.quark.atom.cassandra.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
        Optional<User> existingUserOpt = this.userRepository.findById(User.getId());
        if (existingUserOpt.isPresent()) {
            this.userRepository.save(existingUserOpt.get());
        }
        return User;
    }

    @Override
    public User findOne(UUID uuid) {
    	Optional<User> existingUserOpt = this.userRepository.findById(uuid);
        return existingUserOpt.get();
    }

    @Override
    public void delete(UUID uuid) {
    	Optional<User> existingUserOpt = this.userRepository.findById(uuid);
        if (existingUserOpt.isPresent()) {
            this.userRepository.delete(existingUserOpt.get());
        }
    }


	@Override
	public List<User> findUsersWithAuthLevel(String authLevel) {
		log.info("Retrieve users with authLevel: {}", authLevel);
		return this.userRepository.findByAuthLevel(authLevel);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
