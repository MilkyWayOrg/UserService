package org.milkyway.user.repository;

import java.util.Optional;

import org.milkyway.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public Optional<UserEntity> findByUserName(String userName);
	public String findRoleById(Long id);
}
