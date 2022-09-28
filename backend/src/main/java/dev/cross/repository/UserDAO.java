package dev.cross.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.cross.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	//Login
	@Query(value="select id from reimburse.users where "
			+ "username = :u and "
			+ "pass = :p", nativeQuery = true)
	public Integer login(String u, String p);
}