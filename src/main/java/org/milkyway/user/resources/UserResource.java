package org.milkyway.user.resources;

import org.milkyway.user.controller.UserController;
import org.milkyway.user.entity.UserEntity;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@JsonInclude(Include.NON_NULL)
public class UserResource extends ResourceSupport {
	private final UserEntity userEntity;
	
	public UserResource(UserEntity userEntity) {
		this.userEntity=userEntity;
		add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-user"));
		add(linkTo(methodOn(UserController.class).getUserByIdOrUserName(userEntity.getUserName())).withSelfRel());
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}


}
