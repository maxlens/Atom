package com.quark.atom.mongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.quark.atom.mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

	public List<User> findByAuthLevel(String authLevel);

}
