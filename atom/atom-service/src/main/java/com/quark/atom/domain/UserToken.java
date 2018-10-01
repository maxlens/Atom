package com.quark.atom.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="username")
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String token;

}