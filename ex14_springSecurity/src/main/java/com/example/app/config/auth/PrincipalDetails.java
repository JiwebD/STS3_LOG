package com.example.app.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.app.domain.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 유저 정보 담는 곳

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {
	private UserDto userDto;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //권한체크
		Collection <GrantedAuthority> authorities = new ArrayList();
		authorities.add(new SimpleGrantedAuthority(userDto.getRole()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userDto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
