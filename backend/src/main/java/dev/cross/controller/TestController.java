package dev.cross.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

	//@RequestMapping("/test", method = RequestMethod.GET)
	
	@RequestMapping("/test")
	public String getTest() {
		return "Test Request";
	}
}
