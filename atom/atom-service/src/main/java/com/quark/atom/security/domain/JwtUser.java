package com.quark.atom.security.domain;

import java.util.Collection;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtUser implements UserDetails {
	private static final long serialVersionUID = 1L;

	private final ObjectId id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date passwordResetDate;
    
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
