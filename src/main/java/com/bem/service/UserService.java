package com.bem.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bem.domain.LocalAuth;
import com.bem.domain.User;
import com.bem.domain.UserDto;
import com.bem.domain.UserRegDto;
import com.bem.repository.UserRepository;
import com.bem.utils.Constant;
import com.mysql.fabric.xmlrpc.base.Array;

import ch.qos.logback.core.joran.util.beans.BeanUtil;


@Component
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
		LocalAuth localAuth = new LocalAuth(Ruser.getAccountid(), Ruser.getEmail(), bCryptPasswordEncoder.encode(Ruser.getSetpw()), user);
		userRepository.SaveLocalAuth(localAuth);
	}
	
	public void updateUser(User user){
		userRepository.UpdateUser(user);
	}
	public void update(UserDto userDto,User user){
		BeanUtils.copyProperties(userDto, user);
		userRepository.UpdateUser(user);
	}
	
	
}
