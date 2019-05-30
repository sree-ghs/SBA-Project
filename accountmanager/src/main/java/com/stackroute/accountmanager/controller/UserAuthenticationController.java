package com.stackroute.accountmanager.controller;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.service.UserAuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api
public class UserAuthenticationController {
	static final long EXPIRATIONTIME = 90000000;
	Map<String, String> map = new HashMap<>();
	Map<String, String> loginMap = new HashMap<>();

	UserAuthenticationService authicationService;
	@Autowired 
    public UserAuthenticationController(UserAuthenticationService authicationService) {
		this.authicationService = authicationService;
	}

	@CrossOrigin
	@PostMapping("api/v1/auth/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			authicationService.saveUser(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
	}



	@CrossOrigin
	@PostMapping("api/v1/auth/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User currentUser = new User();
		try {
			currentUser = authicationService.findByUserIdAndPassword(user.getUserId(),user.getUserPassword());
			
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String jwtToken = "";
		try {
			jwtToken = getToken(user.getUserId(), user.getUserPassword());
			map.clear();
			map.put("username", currentUser.getUserId());
			map.put("message","uer successfully logged in");
			map.put("token", jwtToken);
		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			map.clear();
			map.put("token", null);
			map.put("message", exceptionMessage);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}




// Generate JWT token
	public String getToken(String username, String password) throws Exception {
		String jwtToken = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		return jwtToken;
        
}
	
	@CrossOrigin
	@ApiOperation(value = "isAuthenticated")
    @PostMapping("/api/v1/auth/login/isAuthenticated")
	public  ResponseEntity<?> isAuthenticated(ServletRequest req) throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		
		final String authHeader = request.getHeader("authorization");


			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}

			final String token = authHeader.substring(7);
			try {
			final Claims claims = Jwts.parser()
									  .setSigningKey("secretkey")
									  .parseClaimsJws(token)
									  .getBody();
			loginMap.clear();
			loginMap.put("isAuthenticated", "true");
			loginMap.put("message", "Vaild Token");
			return new ResponseEntity<>(loginMap, HttpStatus.OK);
			}catch(Exception e) {
				System.out.println("Invalid Token");

				loginMap.clear();
				loginMap.put("isAuthenticated", "false");
				loginMap.put("message", "Invalid Token");
				return new ResponseEntity<>(loginMap, HttpStatus.UNAUTHORIZED);
			}
    }


}
