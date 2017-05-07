package com.bem.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bem.domain.LocalAuth;
import com.bem.service.UserService;



public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LocalAuth localAuth = userService.findUserByUsername(username);
        if(localAuth == null){
            throw new UsernameNotFoundException("not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(localAuth.getUser().getRole().name()));
        return new org.springframework.security.core.userdetails.User(localAuth.getUsername(),localAuth.getPassword(), authorities);
    }

}