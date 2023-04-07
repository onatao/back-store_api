package dev.natao.projectweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.natao.projectweb.entities.User;
import dev.natao.projectweb.repositories.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> userOpt = repository.findById(id);
		return userOpt.get();
	}

}
