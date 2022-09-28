package dev.cross.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	@Id
	@Column(name="category")
	String category;
	
	@Column(name="percentage")
	int percentage;

	public Category(String category, int percentage) {
		super();
		this.category = category;
		this.percentage = percentage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	
	
}
