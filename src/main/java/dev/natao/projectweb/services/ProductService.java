package dev.natao.projectweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natao.projectweb.entities.Product;
import dev.natao.projectweb.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public List<Product> findAll() {
		List<Product> responseList = repository.findAll();
		return responseList;
	}
	
	public Product findById(Long id) {
		Optional<Product> responseProduct = repository.findById(id);
		return responseProduct.get();
	}

}
