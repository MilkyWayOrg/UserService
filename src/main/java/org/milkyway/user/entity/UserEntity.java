package org.milkyway.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Immutable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Long id;
	
	@NotEmpty
	@JsonProperty("name")
	private String name;
	
	@NotEmpty
	@JsonProperty("userName")
	@Column(unique=true)
	private String userName;
	
	@NotEmpty
	@JsonProperty("role")
	private String role;
	
	@NotEmpty
	@JsonIgnore
	@JsonProperty("password")
	private String password;
	

/*	@OneToMany
	@JoinColumn(name="id")
	private List<RepositoryEntity> repositories;*/
	
	@JsonProperty("createdAt")
	private final Date userCreatedAt=new Date();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUserCreatedAt() {
		return userCreatedAt;
	}
	
}
