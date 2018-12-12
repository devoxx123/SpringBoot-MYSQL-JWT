package com.jwt.web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private String username;
	private String password;
	private boolean enabled = true;
	private boolean credentialsexpired = false;
	private boolean expired = false;
	private boolean locked = false;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "AccountRole", joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "accountId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
	private Set<Role> roles;

	public Account() {

	}

	public Account(Account account) {
		this.accountId = account.getAccountId();
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.enabled = account.isEnabled();
		this.credentialsexpired = account.isCredentialsexpired();
		this.locked = account.isExpired();
		this.roles = account.getRoles();
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public boolean isCredentialsexpired() {
		return credentialsexpired;
	}

	public void setCredentialsexpired(boolean credentialsexpired) {
		this.credentialsexpired = credentialsexpired;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
