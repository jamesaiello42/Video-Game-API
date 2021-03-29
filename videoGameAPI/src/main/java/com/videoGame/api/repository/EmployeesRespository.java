package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Employees;

public interface EmployeesRespository extends CrudRepository<Employees, Long> {

}
