package dev.cross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
