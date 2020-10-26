package com.longIt.shoppingApp.mapper;

import com.longIt.shoppingApp.bean.Shopcar;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ShopcarMapper 数据访问类
 */
public interface ShopcarMapper {

	/**
	 * @param userId
	 * @param id
	 * @return
	 * 
	 */
	@Select("select * from ec_shopcar where user_id = #{userId} and article_id=#{id}")
	Shopcar getShopCarByUserIdAndArticleId(@Param("userId") int userId, @Param("id") int id);

	/**
	 * @param userId
	 * @param id
	 * @param number
	 */
	@Update("update ec_shopcar set buynum = #{number} + buynum where user_id = #{userId} and article_id=#{id}")
	void updateShopCar(@Param("userId") int userId, @Param("id") int id, @Param("number") int number);

	/**
	 * @param userId
	 * @param id
	 * @param number
	 */
	@Insert("insert into ec_shopcar(buynum,user_id,article_id) values(#{number},#{userId},#{id})")
	void addShopCar(@Param("userId") int userId, @Param("id") int id, @Param("number") int number);

	/**
	 * @param userId
	 * @return
	 * 获取用户的购物详情信息
	 */
	List<Shopcar> getAllShopCarByUserId(int userId);

	/**
	 * @param id
	 * @param number
	 * @param number2
	 *
	 */
	@Update("update ec_shopcar set buynum = #{buyNum}  where user_id = #{userId} and article_id=#{id}")
	void updateShopcar(@Param("userId") int userId, @Param("id") int id, @Param("buyNum") int buyNum);

	/**
	 * @param userId
	 * @param id
	 */
	@Delete("delete from ec_shopcar where user_id = #{userId} and article_id=#{id}")
	void deleteShopcar(@Param("userId") int userId, @Param("id") int id);



}