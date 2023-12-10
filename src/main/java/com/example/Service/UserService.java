package com.example.service;

import com.example.dto.UserSaveRequestDTO;
import com.example.entity.Users;

public interface UserService {
	String join(UserSaveRequestDTO userSaveRequestDTO);
	public Users getUser(Users user);
	
	
	//Map<String, String> validateHandling(Errors errors);

	
	//Users signupUser(Users user);
	//Users loginUser(String userid, String password);
	//Users loginUser(Users user);
	
	
	
}
