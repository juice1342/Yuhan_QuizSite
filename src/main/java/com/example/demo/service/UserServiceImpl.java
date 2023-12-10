package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String join(UserSaveRequestDTO userSaveRequestDTO) {
		Users user = Users.builder()
				.userid(userSaveRequestDTO.getUserid())
				.password(userSaveRequestDTO.getPassword())
				.name(userSaveRequestDTO.getName())
				.email(userSaveRequestDTO.getEmail())
				.nickname(userSaveRequestDTO.getNickname())
				.phone_number(userSaveRequestDTO.getPhone_number())
				.build();
				
		return userRepository.save(user).getUserid();
	}

	@Override
	public Users getUser(Users user) {
		Optional<Users> findUser = userRepository.findById(user.getUserid());
			if(findUser.isPresent())
				return findUser.get();
			else
			    return null;
	}
}
