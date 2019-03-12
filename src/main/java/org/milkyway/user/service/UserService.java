package org.milkyway.user.service;

import java.util.List;
import java.util.Optional;
import org.milkyway.user.entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 
 * @author 
 * Prashanth H<br/>
 *
 *
 * */
public interface UserService {
	//Get All Users
	public List<UserEntity> getAllUsers();
	
	//Get user by userName
	public Optional<UserEntity> getUserByIdOrUserName(String userName);
	
	//Create
	public UserEntity createUser(UserEntity userEntity);
	
	//Update
	public void updateUser(UserEntity userEntity);
	
	//Delete
	public void deleteUser(Long userId);
	
	@JsonIgnoreProperties({"name","password"})
	public UserEntity getRole(Long userId);
}
