package dev.cross.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.cross.model.User;
import dev.cross.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Integer> login(@RequestBody User creds) {
		System.out.println(creds);
		int value = userService.login(creds.getUsername(), creds.getPassword());
		
		if (value == -1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(value);
		}
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET) 
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		User u = userService.getUserByID(id);
		
		if (u == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(u); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserList() {
		List<User> uL = userService.getUserList();
		
		if (uL == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uL); 
		} else if (uL.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(uL);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(uL);
		}
	}
}
