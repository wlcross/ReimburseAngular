package dev.cross.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer uID;
	
	@Column(name="username")
	String username;
	
	@Column(name="pass")
	String password;
	
	@Column(name="fname")
	String firstName;
	
	@Column(name="lname")
	String lastName;
	
	@Column(name="manager")
	boolean manager;
	
	@Column(name="remaining")
	int remaining;

	public User(Integer uID, String username, String password, String firstName, String lastName, boolean manager,
			int remaining) {
		super();
		this.uID = uID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.remaining = remaining;
	}
	
	public User() {
		
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	public void reduceRemaining(int reduction) {
		this.remaining -= reduction;
	}

	//TODO DELETE
	@Override
	public String toString() {
		return "User [uID=" + uID + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", manager=" + manager + ", remaining=" + remaining + "]";
	}
	
	
	
}
