package com.quark.atom.cassandra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.quark.atom.cassandra.domain.User;

@RepositoryRestResource(collectionResourceRel = "cassandrausers", path = "cassandrausers")
public interface UserCassandraRepository extends CassandraRepository<User, UUID> {

	// path = http://localhost:8080/cassandrausers/search/findByAuthLevel?authLevel=Guest
	public List<User> findByAuthLevel(@Param("authLevel") String authLevel);

	// path = http://localhost:8080/cassandrausers/search/findByFirstName?firstname=johndoe
	public List<User> findByFirstName(@Param("firstname") String firstname);

	// path = http://localhost:8080/cassandrausers/search/lastname?lastname=janedoe
	@RestResource(path = "lastname")
	public List<User> findByLastName(String lastname);

	// path = http://localhost:8080/cassandrausers/search/fnln?lastname=doe&firstname=john&page=0&size=5&sort=asc
	@RestResource(path = "fnln")
	Slice<User> findByLastNameContainingAndFirstNameContainingAllIgnoringCase(@Param("lastname") String lastname,
			@Param("firstname") String firstname, Pageable pageable);

	// path = http://localhost:8080/cassandrausers/search/findByLastNameAndFirstNameAllIgnoringCase?lastname=doe&firstname=john
	User findByLastNameAndFirstNameAllIgnoringCase(@Param("lastname") String lastname, @Param("firstname") String firstname);

	/* Do not expose Delete methods */
	@Override
	@RestResource(exported = false)
	void deleteById(UUID id);

	@Override
	@RestResource(exported = false)
	void delete(User user);
	/* Do not expose Delete methods */

}
