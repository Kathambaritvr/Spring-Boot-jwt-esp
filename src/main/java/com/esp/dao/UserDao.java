package com.esp.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esp.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    Optional<User> findById(String id);
	User deleteById(String id);
	Optional<User> findByEmail(String email);
}
