package java.com.longIt.shoppingApp.mapper;

import com.longIt.shoppingApp.bean.Order;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * OrderMapper 数据访问类
 */
public interface OrderMapper {

	/**
	 * @param order
	 * 保存订单信息
	 */
	void saveOrder(Order order);

	/**
	 * @param userId
	 * @return
	 * 根据用户id获取该用户所有的订单信息
	 */
	List<Order> getOrdersByUserId(int userId);

	//修改订单状态
	@Update("update ec_order set pay_status = '1' where order_code = #{orderNo}")
	void updateOrderPayOrderNo(String orderNo);



}