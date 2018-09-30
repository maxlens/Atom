package com.quark.atom.mongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.quark.atom.mongodb.domain.User;

@RepositoryRestResource(collectionResourceRel = "mongousers", path="mongousers")
public interface UserRepository extends MongoRepository<User, ObjectId> {
	
	// path = http://localhost:8080/mongousers/search/findByFirstName?firstname=johndoe
	public List<User> findByFirstName(@Param("firstname") String firstname);
	
	// path = http://localhost:8080/mongousers/search/lastname?lastname=janedoe
	@RestResource(path="lastname")
	public List<User> findByLastName(String lastname);
	
	// path = http://localhost:8080/mongousers/search/fnln?lastname=doe&firstname=john&page=0&size=5&sort=ascc
	@RestResource(path="fnln")
	Page<User> findByLastNameContainingAndFirstNameContainingAllIgnoringCase(@Param("lastname") String lastname,
			@Param("firstname") String firstname, Pageable pageable);
	
	// path = http://localhost:8080/mongousers/search/findByLastNameAndFirstNameAllIgnoringCase?lastname=Sienfeld&firstname=Jerry
	User findByLastNameAndFirstNameAllIgnoringCase(@Param("lastname") String lastname, @Param("firstname") String firstname);

	/* Do not expose Delete methods */
	@Override
	@RestResource(exported=false)
	void deleteById(ObjectId id);
	
	@Override
	@RestResource(exported=false)
	void delete(User user);	
	/* Do not expose Delete methods */

}
