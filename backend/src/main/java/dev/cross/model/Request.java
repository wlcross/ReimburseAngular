package dev.cross.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name="requests")
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer rID;
	
	@Column(name="userid")
	int uID;
	
	@Column(name="category")
	String category;
	
	@Column(name="value")
	int value;
	
	@Column(name="requestedamount")
	int requestedAmount;
	
	@Column(name="owedamount")
	int owedAmount;
	
	@Column(name="closed")
	boolean closed;
	
	@Column(name="accepted")
	boolean accepted;
	
	@Column(name="managerhandling")
	Integer managerID;

	public Request(int rID, int uID, String category, int value, int requestedAmount, int owedAmount, boolean closed,
			boolean accepted, Integer managerID) {
		super();
		this.rID = rID;
		this.uID = uID;
		this.category = category;
		this.value = value;
		this.requestedAmount = requestedAmount;
		this.owedAmount = owedAmount;
		this.closed = closed;
		this.accepted = accepted;
		this.managerID = managerID;
	}
	
	public Request() {
		
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(int requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public int getOwedAmount() {
		return owedAmount;
	}

	public void setOwedAmount(int owedAmount) {
		this.owedAmount = owedAmount;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}
	
	
}
