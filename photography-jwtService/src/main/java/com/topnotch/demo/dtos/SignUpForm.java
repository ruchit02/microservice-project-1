package com.topnotch.demo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignUpForm implements Serializable {

	@NotNull
	@NotEmpty
	private String first_name;
	
	@NotNull
	@NotEmpty
	private String last_name;
	
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String pass_word;

	
	
	
	public SignUpForm() { super(); }
	
	public SignUpForm(@NotNull @NotEmpty String first_name, @NotNull @NotEmpty String last_name,
			@NotNull @NotEmpty String email, @NotNull @NotEmpty String pass_word) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.pass_word = pass_word;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
}
