package com.longIt.shoppingApp_manager.mapper;

import com.longIt.shoppingApp.bean.Article;
import com.longIt.shoppingApp_manager.util.pager.PageModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ArticleMapper 数据访问类
 * @version 1.0
 */
public interface ManagerArticleMapper {

	/**
	 * @return
	 */
	
	List<Article> getAllArticles(@Param("typeCode")String typeCode,@Param("title")String title,@Param("pageModel")PageModel pageModel);

	/**
	 * @param id
	 * @return
	 * 根据商品id获取商品信息
	 */
	@Select("select * from  ec_article where id = #{id}")
	Article getArticleById(Integer id);

	/**
	 * @param id
	 */
	@Update("update ec_article set disabled = '1' where id = #{id}")
	void removeArticleById(Integer id);

	/**
	 * @param typeCode
	 * @param title
	 * @return
	 * //进行分页查询之前获取总记录数
	 */
	int getTotalNum(@Param("typeCode")String typeCode,@Param("title")String tite);

	/**
	 * @param article
	 * //保存商品信息
	 */
	void saveArtice(Article article);

	/**
	 * @param article
	 * 更新商品信息
	 */
	void updateArticle(Article article);


}