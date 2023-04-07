package dev.natao.projectweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.natao.projectweb.entities.Category;
import dev.natao.projectweb.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> responseList = service.findAll();
		return new ResponseEntity<>(responseList, HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findByid(@PathVariable Long id) {
		Category responseCategory = service.findById(id);
		return new ResponseEntity<>(responseCategory, HttpStatus.OK);
	}

}
