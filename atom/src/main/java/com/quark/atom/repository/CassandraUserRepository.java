package com.quark.atom.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.quark.atom.domain.User;

@Repository
public class CassandraUserRepository implements UserRepository {

	private final CassandraOperations cassandraTemplate;

	public CassandraUserRepository(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Override
	public void save(User user) {
		this.cassandraTemplate.insert(user);
	}

	@Override
	public void update(User user) {
		this.cassandraTemplate.update(user);
	}

	@Override
	public User findOne(UUID uuid) {
		return this.cassandraTemplate.selectOneById(uuid, User.class);
	}

	@Override
	public void delete(UUID uuid) {
		this.cassandraTemplate.deleteById(uuid, User.class);
	}

	@Override
	public List<User> findUsersWithAuthLevel(String authLevel) {
        Select select = QueryBuilder.select().from("user");
        select.where(QueryBuilder.contains("authlevel", authLevel));
        return this.cassandraTemplate.select(select, User.class);
	}

	@Override
	public List<User> findAll() {
		return this.cassandraTemplate.select(QueryBuilder.select().from("user"), User.class);
	}

}
