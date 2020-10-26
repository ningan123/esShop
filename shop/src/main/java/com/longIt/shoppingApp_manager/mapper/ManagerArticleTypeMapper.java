package com.longIt.shoppingApp_manager.mapper;

import com.longIt.shoppingApp.bean.ArticleType;
import com.longIt.shoppingApp_manager.util.pager.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ArticleTypeMapper 数据访问类
 * @version 1.0
 */
public interface ManagerArticleTypeMapper {

	/**
	 * @return
	 * 获取所有的一级商品类型
	 */
	@Select("select * from ec_article_type where length(code) = 4")
	List<ArticleType> findAllFirstArticleType();

	/**
	 * @return
	 */
	@Select("select count(*) from ec_article_type")
	int findTotalNum();

	/**
	 * @param pageModel
	 * @return
	 * 根据商品类型以及商品的标题获取商品信息
	 */
	@Select("select * from ec_article_type limit #{startNum} , #{pageSize}")
	List<ArticleType> getAllArticleTypes(PageModel pageModel);

	/**
	 * @param code
	 * @return
	 * 加载修改商品类型页面  
	 */
	@Select("select * from ec_article_type where code = #{code}")
	ArticleType getArticleTypeByCode(String code);

	/**
	 * @param type
	 * 进行更新商品类型操作
	 */
	@Update("update ec_article_type set name = #{name},remark=#{remark} where code = #{code}")
	void updateArticleType(ArticleType type);

	/**
	 * @param string
	 * @return
	 */
	@Select("SELECT MAX(CODE) FROM ec_article_type WHERE CODE LIKE #{parentCode} and length(code) = 8")
	String findMaxSeCode(String parentCode);

	/**
	 * @return
	 * 获取最大的一级物品类型code
	 */
	@Select("SELECT MAX(CODE) FROM ec_article_type WHERE  length(code) = 4")
	String findMaxFiCode();

	/**
	 * @param type
	 */
	@Insert("insert into ec_article_type(code,name,remark) values(#{code},#{name},#{remark})")
	void saveArticleType(ArticleType type);

	/**
	 * @param code
	 * @param i
	 * @return
	 */
	@Select("SELECT * FROM ec_article_type WHERE CODE LIKE #{code} and length(code) = #{len}")
	List<ArticleType> getArticleType(@Param("code")String code, @Param("len")int len);

	/**
	 * @param code
	 */
	@Delete("delete from ec_article_type where code = #{code}")
	void deleteTypes(String code);



}