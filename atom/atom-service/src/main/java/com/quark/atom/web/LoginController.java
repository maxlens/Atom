package com.quark.atom.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quark.atom.domain.Credentials;
import com.quark.atom.domain.UserToken;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public UserToken postCredentials(@RequestBody Credentials credentials) {
		return new UserToken(credentials.getUsername(), "jwttoken");
	}

}
