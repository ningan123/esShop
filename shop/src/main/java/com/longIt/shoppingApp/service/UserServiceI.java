/**
 * 
 */
package com.longIt.shoppingApp.service;

import com.longIt.shoppingApp.bean.User;

import javax.servlet.http.HttpServletRequest;


public interface UserServiceI {

	/**
	 * @param user
	 * @return
	 * //根据用户输入的账号以及密码获取用户的信息
	 */
	User findUserByNameAndPass(User user);

	/**
	 * @param loginName
	 * @return
	 * //异步校验账号是否存在
	 */
	String validLoginName(String loginName);

	/**
	 * @param user
	 *  //用户注册
	 */
	void saveUser(User user,HttpServletRequest request);

	/**
	 * @param activeCode
	 * //用户信息激活
	 */
	String active(String activeCode);

	
	
}
