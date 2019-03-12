package org.milkyway.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.milkyway.user.entity.UserEntity;
import org.milkyway.user.resources.UserResource;
import org.milkyway.user.service.UserService;
import org.milkyway.user.util.SelfServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/**
 * 
 * @author 
 * Prashanth H<br/>
 *
 *
 * */
@RestController
@RequestMapping("userService")
public class UserController {
	
	@Autowired UserService userService;
	
	/**
	 * To get list of all users
	 * @return List<@UserResource>
	 */
	@GetMapping("user")
	public ResponseEntity<Resources<UserResource>> getAllUsers(){
		List<UserEntity> userList=userService.getAllUsers();
		List<UserResource> collection=userList.stream().map(UserResource::new).collect(Collectors.toList());
		final Resources < UserResource > resources = new Resources < > (collection);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	/**
	 * To get user by Id
	 * @return UserResource
	 */
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserResource> getUserByIdOrUserName(@PathVariable(name="userId") String userIdOrName){
		UserEntity userEntity=userService.getUserByIdOrUserName(userIdOrName).get();
		return ResponseEntity.ok(new UserResource(userEntity));
	}
	/**
	 * To user role by Id
	 * @return UserResource
	 */
	@GetMapping("/user/{userId}/role")
	public ResponseEntity<UserResource> getUserRoleById(@PathVariable(name="userId") Long userId){
		
		
		
		return ResponseEntity.ok(new UserResource(null));
	}

	/**
	 * To create user
	 * @return UserResource
	 */
	@PostMapping("/user")
	public ResponseEntity<UserResource> createUser(@Valid @RequestBody UserEntity userEntity,Errors errors){
		if(errors.hasErrors())
			SelfServiceUtil.throwInvalidArgumentException(errors);
		UserEntity savedUserEntity=userService.createUser(userEntity);
		return ResponseEntity.ok(new UserResource(savedUserEntity));
	}
	
	/**
	 * To update user
	 * @return UserResource
	 */
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserResource> updateUser(@PathVariable(name="userId") String repoKeyOrId,@Valid @RequestBody UserEntity userEntity,Errors errors){
		if(errors.hasErrors())
			SelfServiceUtil.throwInvalidArgumentException(errors);
		userService.updateUser(userEntity);
		return ResponseEntity.ok(new UserResource(null));
	}

	/**
	 * To delete user by ID
	 * @return UserResource
	 */
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<UserResource> deleteUserById(@PathVariable(name="userId") String userId){
		return ResponseEntity.ok(new UserResource(null));
	}
}
