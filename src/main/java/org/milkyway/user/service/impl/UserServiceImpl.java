package org.milkyway.user.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.milkyway.user.entity.UserEntity;
import org.milkyway.user.exceptions.ResourceAlreadyExistsException;
import org.milkyway.user.exceptions.ResourceNotFoundException;
import org.milkyway.user.repository.UserRepository;
import org.milkyway.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 
 * Prashanth H<br/>
 */
@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = userRepository.findAll();
		if(userList.isEmpty())
			throw new ResourceNotFoundException("No users created");
		return userList;
	}


	@Override
	public Optional<UserEntity> getUserByIdOrUserName(String userIdOrName) {
		Optional<UserEntity> userEntity=userRepository.findByUserName(userIdOrName);
		if(!userEntity.isPresent()) {
			if(userIdOrName.matches("\\d+"))
				userEntity=userRepository.findById(Long.parseLong(userIdOrName));
			else
				throw new ResourceNotFoundException("User ID not found "+userIdOrName);
		}
		if(!userEntity.isPresent())
			throw new ResourceNotFoundException("User Name not found "+userIdOrName);
		
		return userEntity;
	}
	
	@Override
	public UserEntity createUser(UserEntity userEntity) {
		String userName=userEntity.getUserName();
		Optional<UserEntity> user=userRepository.findByUserName(userName);
		if(user.isPresent())
			throw new ResourceAlreadyExistsException("User Name already exists "+userName);
		return userRepository.save(userEntity);
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		
		
	}

	@Override
	public void deleteUser(Long userId) {
		
		
	}

	@Override
	public UserEntity getRole(Long userId) {
		
		return null;
	}
	
	


}
