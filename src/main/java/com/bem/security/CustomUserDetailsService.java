package com.bem.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bem.domain.LocalAuth;
import com.bem.repository.UserRepository;


public class CustomUserDetailsService implements UserDetailsService {
	@Resource
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		LocalAuth user = userRepository.findUserByAccount(account);
		if(user == null){
            throw new UsernameNotFoundException("not found");
        }
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUser().getRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
	}
}
