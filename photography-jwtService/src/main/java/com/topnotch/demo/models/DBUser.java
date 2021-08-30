package com.topnotch.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="users")
public class DBUser implements Serializable {

	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	//PRIMARY KEY
	@Id
	@Column(name="email")
	private String username;
	
	@Column(name="pass_word")
	private String pass_word;
	
	//RELATION
	@OneToMany(mappedBy="username", fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Authority> authorities;
	
	
	
	
	public DBUser() { super(); }

	public DBUser(String first_name, String last_name, String username, String pass_word, List<Authority> authorities) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.pass_word = pass_word;
		this.authorities = authorities;
	}

	
	
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
