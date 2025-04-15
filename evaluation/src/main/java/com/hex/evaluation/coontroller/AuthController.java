package com.hex.evaluation.coontroller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.evaluation.config.JwtUtil;
import com.hex.evaluation.dto.TokenDto;
import com.hex.evaluation.exception.InvalidUserNameException;
import com.hex.evaluation.model.User;
import com.hex.evaluation.service.AuthService;
import com.hex.evaluation.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService myUserService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/signup")
	public User addLogin(@RequestBody User user) throws InvalidUserNameException {
		return authService.add(user);
	}
	
	@PostMapping("/login")
	public UserDetails Login(Principal principal) {
		String username=principal.getName();
		return myUserService.loadUserByUsername(username);
		}
	
	@PostMapping("/token/generate")
	public TokenDto generateToken(@RequestBody User user1,TokenDto dto) {
		Authentication auth = 
		new UsernamePasswordAuthenticationToken(user1.getUsername(),user1.getPassword());
	
		authenticationManager.authenticate(auth);
		
		String token =  jwtUtil.generateToken(user1.getUsername()); 
		dto.setToken(token);
		dto.setUsername(user1.getUsername());
		dto.setExpiry(jwtUtil.extractExpiration(token).toString());
		return dto; 
	}
	@PostMapping("/userDetails")
	public UserDetails userDetails(Principal principal) {
		String username=principal.getName();
		return myUserService.loadUserByUsername(username);
	}
}
