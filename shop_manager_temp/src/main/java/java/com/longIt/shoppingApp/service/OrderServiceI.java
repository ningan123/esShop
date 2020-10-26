/**
 * 
 */
package java.com.longIt.shoppingApp.service;

import com.longIt.shoppingApp.bean.Order;

import java.util.List;


public interface OrderServiceI {

	/**
	 * @param orderInfo
	 * 提交订单
	 */
	Order orderSubmit(String orderInfo);

	/**
	 * @return
	 * 根据当前用户的id查询，该用户所有的订单信息
	 */
	List<Order> getOrdersByUserId();

	//修改支付状态
	void updateOrderPayOrderNo(String orderNo);


	

}
