package java.com.longIt.shoppingApp.bean;

/**
 * Shopcar 数据传输类
 * @version 1.0
 */
public class Shopcar implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int buynum;
	private int userId;
	private int articleId;
	
	private Article article;

	/** setter and getter method */
	public void setBuynum(int buynum){
		this.buynum = buynum;
	}
	public int getBuynum(){
		return this.buynum;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}
	public int getArticleId(){
		return this.articleId;
	}
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}


	@Override
	public String toString() {
		return "Shopcar{" +
				"buynum=" + buynum +
				", userId=" + userId +
				", articleId=" + articleId +
				", article=" + article +
				'}';
	}
}