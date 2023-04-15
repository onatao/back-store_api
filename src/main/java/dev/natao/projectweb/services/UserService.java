package dev.natao.projectweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dev.natao.projectweb.entities.User;
import dev.natao.projectweb.repositories.UserRepository;
import dev.natao.projectweb.services.exceptions.DatabaseException;
import dev.natao.projectweb.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> userOpt = repository.findById(id);
		// Lambda expression (will return ResourceNotFoundException)
		return userOpt.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		// Reference entity
		User entity = repository.getReferenceById(id); 
		updateData(entity, user);
		return repository.save(entity);
		
	}
	/**
	 * Update entity data.
	 * @param entity
	 * @param user
	 */
	private void updateData(User entity, User user) {
		entity.setUserName(user.getUserName());
		entity.setUserEmail(user.getUserEmail());
		entity.setUserPhone(user.getUserPhone());
	}
}
