package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Users;

public interface UsersRespository extends CrudRepository<Users, Long> {

}
