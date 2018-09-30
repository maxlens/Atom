package com.quark.atom.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.atom.mongodb.domain.User;
import com.quark.atom.mongodb.repository.UserRepository;

/*import com.quark.atom.cassandra.domain.User;
import com.quark.atom.cassandra.repository.UserRepository;*/

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(ObjectId.get());
        }
        this.userRepository.save(user);
        return user;
}

    public User update(User User) {
        Optional<User> existingUserOpt = this.userRepository.findById(User.getId());
        if (existingUserOpt.isPresent()) {
            this.userRepository.save(existingUserOpt.get());
        }
        return User;
    }
 
/*	public List<User> findUsersWithAuthLevel(String authLevel) {
		log.info("Retrieve users with authLevel: {}", authLevel);
		return this.userRepository.findByAuthLevel(authLevel);
	}*/

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
