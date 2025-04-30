package com.example.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		//로그인 폼에서 아이디 입력하면 유저내임을  String username에 받아옴

		UserDto userDto = userMapper.selectAt(username);
		if(userDto==null)
			throw new UsernameNotFoundException(username + " 존재하지 않는 계정입니다.");
		
		return new PrincipalDetails(userDto);
	}
	

}
