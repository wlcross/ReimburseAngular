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

import dev.cross.model.Request;
import dev.cross.service.RequestService;

@CrossOrigin
@RestController
public class RequestController {

	private final RequestService requestService;
	
	@Autowired
	public RequestController(RequestService requestService) {
		this.requestService = requestService;
	}
	
	@RequestMapping(value = "/createRequest", method = RequestMethod.POST)
	public ResponseEntity<Request> createRequest (@RequestBody Request r) {
		Request finalRequest = requestService.createRequest(r);
		
		if (finalRequest == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(finalRequest); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(finalRequest);
		}
	}
	
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getAllRequests() {
		List<Request> rL = requestService.getAllRequests();
		
		if (rL == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rL);
		} else if (rL.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rL);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(rL);
		}
	}
	
	@RequestMapping(value = "/requests/open", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getOpenRequests() {
		List<Request> rL = requestService.getOpenRequest();
		
		if (rL == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rL);
		} else if (rL.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rL);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(rL);
		}
	}
	
	@RequestMapping(value = "/requests/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getUserRequests(@PathVariable("id") int id) {
		List<Request> rL = requestService.getUserRequests(id);
		
		if (rL == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rL);
		} else if (rL.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rL);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(rL);
		}
	}
	
	@RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
	public ResponseEntity<Request> getRequest(@PathVariable("id") int id) {
		Request r = requestService.getRequest(id);
		
		if (r == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(r);
		}
	}
}
