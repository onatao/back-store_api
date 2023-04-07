package dev.natao.projectweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.natao.projectweb.entities.User;
import dev.natao.projectweb.repositories.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

}
