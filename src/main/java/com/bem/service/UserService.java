package com.bem.service;

import java.util.UUID;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bem.domain.LocalAuth;
import com.bem.domain.User;
import com.bem.domain.UserRegCreateForm;
import com.bem.domain.UserRepository;


@Service("userService")
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	public LocalAuth findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	public void saveUser(UserRegCreateForm Ruser) {
		User user = new User(Ruser.getEmail(), Ruser.getPhone());
		userRepository.SaveUser(user);
		LocalAuth localAuth = new LocalAuth(Ruser.getUsername(), Ruser.getEmail(), Ruser.getPhone(), bCryptPasswordEncoder.encode(Ruser.getPassword()), user);
		userRepository.SaveLocalAuth(localAuth);
	}
}
