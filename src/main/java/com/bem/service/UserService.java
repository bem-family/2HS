package com.bem.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bem.domain.LocalAuth;
import com.bem.domain.User;
import com.bem.domain.UserRegDto;
import com.bem.domain.UserRepository;
import com.bem.utils.Constant;


@Service("userService")
public class UserService {
	@Resource
	private UserRepository userRepository;
	@Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public LocalAuth findUserByAccount(String account) {
		return userRepository.findUserByAccount(account);
	}
	
	public void saveUser(UserRegDto Ruser) {
		User user = new User(Ruser.getEmail(), Constant.UN_AUTH_STATUS);
		userRepository.SaveUser(user);
		LocalAuth localAuth = new LocalAuth(Ruser.getUsername(), Ruser.getEmail(), Ruser.getPhone(), bCryptPasswordEncoder.encode(Ruser.getPassword()), user);
		userRepository.SaveLocalAuth(localAuth);
	}
	
	public void updateUser(User user){
		userRepository.UpdateUser(user);
	}
}
