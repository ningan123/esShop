/**
 * 
 */
package com.longIt.shoppingApp.service;

import com.longIt.shoppingApp.bean.Shopcar;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface ShopCarServiceI {

	/**
	 * @param session
	 * @param id
	 * @param number
	 * 将商品信息加入至购物车
	 */
	void addArticleToShopCar(HttpSession session, int id, int number);

	/**
	 * @param session
	 * @return
	 * 展示购物车中的商品信息
	 */
	List<Shopcar> getAllShopCarByUserId(HttpSession session);

	/**
	 * @param session
	 * @param id
	 * @param number
	 * 更新购物车中商品的购物数量
	 */
	void updateShopcar(HttpSession session, int id, int number);

	/**
	 * @param session
	 * @param id
	 * //删除购物车中商品的购物数量
	 */
	void deleteShopcar(HttpSession session, int id);

	
}
