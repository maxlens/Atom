package com.quark.atom.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private UUID id;
	private String firstName;
	private String lastName;
	private String password;
	private String authLevel;
	private Date created;
	private Date lastLogin;
}
