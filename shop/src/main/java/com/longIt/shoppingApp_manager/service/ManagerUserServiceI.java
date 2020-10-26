/**
 * 
 */
package com.longIt.shoppingApp_manager.service;

import com.longIt.shoppingApp.bean.User;

import javax.servlet.http.HttpServletRequest;


public interface ManagerUserServiceI {

	/**
	 * @param loginName
	 * @param password
	 * @return
	 * 根据账号以及密码获取用户信息
	 */
	User getUserByNameAndPass(User user);

	/**
	 * @param user
	 *  //用户信息注册   
	 */
	void saveUser(User user,HttpServletRequest request) throws Exception;

	/**
	 * @param activeCode
	 * //用户信息激活  
	 */
	void activeUser(String activeCode);

	/**
	 * @param loginName
	 * @return
	 * 根据账号获取用户信息
	 */
	String getUserByLoginName(String loginName);

	


}
