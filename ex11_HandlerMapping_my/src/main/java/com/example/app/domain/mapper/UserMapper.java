package com.example.app.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {

	
	public int insert(UserDto userDto);
	

	public int update(UserDto userDto);

	public int delete(@Param("id") String string);
	
}
