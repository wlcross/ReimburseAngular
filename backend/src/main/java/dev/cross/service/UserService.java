package dev.cross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.cross.model.User;
import dev.cross.repository.UserDAO;

@Service
public class UserService {

	private final UserDAO userDao;
	
	@Autowired
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public Integer login(String u, String p) {
		Integer user = userDao.login(u, p);
		System.out.println("Username: " + u + ", Password: " + p + ", ID: " + user);
		if (user == null) return -1;
		return user;
	}
	
	public User getUserByID(int i) {
		return userDao.getReferenceById(i);
	}
	
	public User createUser(User u) {
		return userDao.save(u);
	}
	
	public List<User> getUserList() {
		return userDao.findAll();
	}
}
