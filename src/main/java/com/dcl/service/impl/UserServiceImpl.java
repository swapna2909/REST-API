package com.dcl.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dto.UserDto;
import com.dcl.entity.User;
import com.dcl.repo.UserRepository;
import com.dcl.request.*;
import com.dcl.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto Register(RegisterRequest request) {
		// TODO Auto-generated method stu0b
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyExists != null) {
			throw new RuntimeException("user already exists!");
		}
		
		//transfering the data from request to entity
//		User user = new User();
//		user.setName(request.getName());
//		user.setEmail(request.getEmail());
//		user.setPhone(request.getPhone());
//		user.setPassword(request.getPassword());
		User user=mapper.map(request,User.class);
		user=urepo.save(user);
		
		
		//tranfering the data from entity to dto
		UserDto dto = mapper.map(user,UserDto.class);
		return dto;
	}

}
