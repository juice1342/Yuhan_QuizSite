package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserSaveRequestDTO;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	
	
	@PostMapping("/signup")
    public String signup(UserSaveRequestDTO userSaveRequestDTO) {
        String userid = userService.join(userSaveRequestDTO);
        return "index";
    }
    
	
}
