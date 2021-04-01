package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
	public Users findByUsername(String username);
}
