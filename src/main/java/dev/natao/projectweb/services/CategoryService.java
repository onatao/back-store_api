package dev.natao.projectweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natao.projectweb.entities.Category;
import dev.natao.projectweb.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public List<Category> findAll() {
		List<Category> responseList = repository.findAll();
		return responseList;
	}
	
	public Category findById(Long id) {
		Optional<Category> categoryResponse = repository.findById(id);
		return categoryResponse.get();
	}

}
