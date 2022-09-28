package dev.cross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.cross.model.Category;
import dev.cross.model.Request;
import dev.cross.model.User;
import dev.cross.repository.CategoryDAO;
import dev.cross.repository.RequestDAO;
import dev.cross.repository.UserDAO;

@Service
public class RequestService {

	private final RequestDAO requestDao;
	private final UserDAO userDao;
	private final CategoryDAO categoryDao;
	
	@Autowired
	public RequestService(RequestDAO requestDao, UserDAO userDao, CategoryDAO categoryDao) {
		this.requestDao = requestDao;
		this.userDao = userDao;
		this.categoryDao = categoryDao;
	}
	
	public List<Request> getAllRequests() {
		return requestDao.findAll();
	}
	
	public List<Request> getUserRequests(int i) {
		return requestDao.getUserRequests(i);
	}
	
	public List<Request> getOpenRequest() {
		return requestDao.getOpenRequests();
	}
	
	public Request createRequest(Request r) {
		int percent = categoryDao.getPercent(r.getCategory());
		double percentage = percent / 100.0;
		double requested = percentage * r.getValue();
		r.setRequestedAmount((int)requested);
		int owed = reduceRemaining(r.getuID(), r.getRequestedAmount());
		r.setOwedAmount(owed);
		r.setClosed(false);
		r.setAccepted(false);
		Request newRequest = requestDao.createRequest(r.getuID(), r.getCategory(), r.getValue(), r.getRequestedAmount(), r.getOwedAmount(), r.isClosed(), r.isAccepted());
		return newRequest;
	}
	
	public int reduceRemaining(int id, int reduction) {
		System.out.println("DEBUG ID " + id);
		User reducer = userDao.getReferenceById(id);
		System.out.println("DEBUG " + reducer.toString());
		int remain = reducer.getRemaining();
		if (remain < reduction) {
			reduction = remain;
		}
		reducer.reduceRemaining(reduction);
		userDao.save(reducer);
		return reduction;
	}
}
