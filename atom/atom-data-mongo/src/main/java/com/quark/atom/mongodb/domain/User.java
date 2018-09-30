package com.quark.atom.mongodb.domain;

import java.io.Serializable;

import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Document(collection="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private BsonTimestamp created;
	private BsonTimestamp lastLogin;
}
