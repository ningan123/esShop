/**
 * 
 */
package com.longIt.shoppingApp.controller;

import com.longIt.shoppingApp.bean.Article;
import com.longIt.shoppingApp.bean.ArticleType;
import com.longIt.shoppingApp.service.ArticleServiceI;
import com.longIt.shoppingApp.util.pager.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// /article/findAllArticle_anantest
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleServiceI articleService;

	@RequestMapping("/findAllArticle_anantest")
	@ResponseBody
	public void findAllArticle(){
		List<ArticleType>  articleTypes = articleService.findAllFirstArticleType();
		for (ArticleType articleType : articleTypes) {
			System.out.println(articleType);
		}
	}





	
	@RequestMapping("/index")
	/**
	 * typeCode: 当分类显示的时候，会把typeCode传过来
	 * keyword：搜索时，会把keyword传过来
	 * PageModel:封装分页类
	 */
	public String  articleIndex(Model model,String typeCode,String keyword,PageModel pageModel) {
	
		//获取所有的一级物品类型
		List<ArticleType>  articleTypes = articleService.findAllFirstArticleType();
		model.addAttribute("articleTypes", articleTypes);
		/**
		 * //model.addattribute()的作用
		 * //1.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到，
		 */



		System.out.println("typeCode:"+typeCode);
		//如果 typecode不为空，则根据typeCode查询二级物品类型
		if(typeCode != null && !typeCode.equals("")) {

            // 0001 ==> 0001     00010001 ==> 0001
			String code = typeCode.substring(0, 4);
			
			//根据一级物品类型获取对应的二级物品类型信息
			List<ArticleType> seArticleTypes = articleService.findAllSecondArticleTypes(code+"%");
			//这个%是因为sql语句要进行模糊查询
			//将二级物品类型存放至 model
			model.addAttribute("secondArticleTypes", seArticleTypes);
		}

		//根据 用户指定的商品类型查询数据库，获取相应的商品信息
		List<Article> articles = articleService.findAllArticle(typeCode == null ? null : typeCode+"%",keyword == null ? null : "%"+keyword+"%",pageModel);
		model.addAttribute("articles", articles);
		
		//查询总记录数
		int totalNum = articleService.findTotalNum(typeCode == null ? null : typeCode+"%",keyword == null ? null : "%"+keyword+"%");
		pageModel.setTotalNum(totalNum);
		

		// WEB-INF/jsp/articleIndex.jsp
	   return "articleIndex";
	}
	
	
	//根据商品id获取商品详情信息
	@RequestMapping("/detail")
	public String articleDetail(Integer id,Model model) {
		//根据商品id获取商品信息
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		
		// /WEB-INF/jsp/articleDetail.jsp
		return "articleDetail";
	}

}
