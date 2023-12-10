package com.example.demo.service;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.entity.Users;

public interface UserService {
	String join(UserSaveRequestDTO userSaveRequestDTO);
	public Users getUser(Users user);
	
	
	//Map<String, String> validateHandling(Errors errors);

	
	//Users signupUser(Users user);
	//Users loginUser(String userid, String password);
	//Users loginUser(Users user);
	
	
	
}
