package dev.cross.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.cross.model.Request;

@Repository
public interface RequestDAO extends JpaRepository<Request, Integer> {

	@Query(value="select * from reimburse.requests where "
			+ "userid = :u", nativeQuery = true)
	public List<Request> getUserRequests(int u);
	
	@Query(value="select * from reimburse.requests where "
			+ "closed = false", nativeQuery = true)
	public List<Request> getOpenRequests();
	
	@Query(value="INSERT INTO reimburse.requests "
			+ "(userid, category, value, requestedamount, owedamount, closed, accepted) "
			+ "VALUES(:u, :c, :v, :rA, :oA, :cl, :a) "
			+ "returning *;", 
			nativeQuery = true)
	public Request createRequest(int u, String c, int v, int rA, int oA, boolean cl, boolean a);
}
