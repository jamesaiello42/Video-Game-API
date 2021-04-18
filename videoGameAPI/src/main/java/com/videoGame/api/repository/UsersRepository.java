package com.videoGame.api.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.videoGame.api.entity.Users;

//Crud repo to access database table users
public interface UsersRepository extends CrudRepository<Users, Long> {
	public Users findByUsername(String username);
	public Optional<Users> findById(Long id);
}
