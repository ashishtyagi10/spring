/**
 * 
 */
package com.ashish.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ashish.spring.web.validation.ValidEmail;

/**
 * @author ashish
 * 
 */
public class User {
	@NotBlank
	@Size(min = 1, max = 15)
	@Pattern(regexp = "^\\w{1,}$")
	private String	username;

	@NotBlank
	@Pattern(regexp = "^\\S+$")
	@Size(min = 1, max = 15)
	private String	password;
	private boolean	enabled;
	private String	authority;

	@ValidEmail
	private String	email;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param authority
	 * @param email
	 */
	public User(String username, String password, boolean enabled, String authority, String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority=" + authority + ", email=" + email
				+ "]";
	}
}
