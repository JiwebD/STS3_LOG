package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(noRollbackFor = Exception.class)
	public boolean userJoin(UserDto userDto) {
		
		userDto.setPassword( passwordEncoder.encode(userDto.getPassword()) );
		userDto.setRole("ROLE_USER");  //"USER"은 Security에서만 ? : Spring Security는 ROLE_ 접두어를 자동으로 붙여서 내부적으로 처리한다.
									   //.hasRole("USER") → 실제로는 "ROLE_USER"와 비교됨.
		int result = userMapper.insert(userDto);
		return result>0;
	}
	
	
}
