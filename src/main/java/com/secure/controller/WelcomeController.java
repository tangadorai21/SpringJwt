package com.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secure.entity.AuthRequest;
import com.secure.util.JwtUtil;
@RestController
public class WelcomeController {
	@Autowired
	private JwtUtil jwtUtil;
	
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "This info is for the authenticated users only";
	}
   // @GetMapping("/hello")
	//public String hello() {
		//return "Hello!!! everyone";
	//}
    @PostMapping("/auth")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
    	}catch (Exception ex) {
    		throw new Exception("Invalid username and password");
    	}
    	return jwtUtil.generateToken(authRequest.getUsername());	
    }
}
