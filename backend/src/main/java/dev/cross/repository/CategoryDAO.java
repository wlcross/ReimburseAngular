package dev.cross.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.cross.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, String> {

	@Query(value="select percentage from reimburse.categories where "
			+ "category = :s", nativeQuery = true)
	public Integer getPercent(String s);
}
