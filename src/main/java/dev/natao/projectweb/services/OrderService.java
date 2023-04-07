package dev.natao.projectweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.natao.projectweb.entities.Order;
import dev.natao.projectweb.repositories.OrderRepository;

public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		List<Order> responseList = repository.findAll();
		return responseList;
	}
	
	public Order findById(Long id) {
		Optional<Order> orderResponse = repository.findById(id);
		return orderResponse.get();
	}

}
