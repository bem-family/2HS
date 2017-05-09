package com.bem.utils;

import com.bem.domain.User;
import com.bem.domain.User.ROLE;

public class Constant {
	/**
	 * 用户角色
	 */
	public final static ROLE HAS_AUTH_STATUS = User.ROLE.USER;
	
	public final static ROLE UN_AUTH_STATUS = User.ROLE.VISITOR;
}
