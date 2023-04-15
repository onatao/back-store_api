package dev.natao.projectweb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.natao.projectweb.entities.User;
import dev.natao.projectweb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> responseList= service.findAll();
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long  id) {
		User userResponse = service.findById(id);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		/**
		 *  Return 201 status and the path where
		 *  the new user was inserted
		 */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(obj.getUserId())
				  .toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // 204 (Void method) 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);
	}
}
