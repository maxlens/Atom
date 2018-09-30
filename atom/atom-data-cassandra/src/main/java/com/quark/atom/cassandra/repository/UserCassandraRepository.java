package com.quark.atom.cassandra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.quark.atom.cassandra.domain.User;

@Repository
public interface UserCassandraRepository extends CassandraRepository<User, UUID> {

	public List<User> findByAuthLevel(String authLevel);

}
