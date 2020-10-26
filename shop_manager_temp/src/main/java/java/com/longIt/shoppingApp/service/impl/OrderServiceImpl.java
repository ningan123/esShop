/**
 * 
 */
package java.com.longIt.shoppingApp.service.impl;

import com.longIt.shoppingApp.bean.Order;
import com.longIt.shoppingApp.bean.OrderItem;
import com.longIt.shoppingApp.bean.User;
import com.longIt.shoppingApp.mapper.OrderItemMapper;
import com.longIt.shoppingApp.mapper.OrderMapper;
import com.longIt.shoppingApp.service.OrderServiceI;
import com.longIt.shoppingApp.weixin.utils.DataJoinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderServiceI {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;

	/* (non-Javadoc)
	 * 提交订单
	 * #1_2_216.0#5_1_158.4   == >  1_2_216.0#5_1_158.4
	 */
	@Override
	public Order orderSubmit(String orderInfo) {
		// TODO Auto-generated method stub
		//创建订单对象
		Order order = new Order();
		try {
			String[]  orderInfos = orderInfo.substring(1).split("#");
			
			
			//指定下单时间
			order.setCreateDate(new Date());
			
			//获取session
			HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			
			//从session中获取用户信息
			int userId = ((User)session.getAttribute("session_user")).getId();
			
			//指定订单属于哪一个用户
			order.setUserId(userId);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			//设置订单编号
			order.setOrderCode("PO-"+sdf.format(new Date())+userId);
			
			
			//定义订单总金额
			double totalPrice = 0.0;
			
			//创建集合用于封装订单详情信息
			List<OrderItem> items = new ArrayList<>();
			for(String  info: orderInfos) {
				String[] infos =info.split("_");
				
				//获取商品id
				int articleId = Integer.valueOf(infos[0]);
				//购买数量
				int buyNum = Integer.valueOf(infos[1]);
				
				OrderItem item = new OrderItem();
				item.setArticleId(articleId);
				item.setOrderNum(buyNum);
				
				//订单详细记录放在集合中
				items.add(item);
				
				totalPrice += Double.valueOf(infos[2]);
			}
			
			//指定订单的总金额
			order.setAmount(totalPrice);
			
			//保存订单信息 ,保存完订单信息之后，需要获取订单的id，因为需要将订单的id存放在订单详情中
			orderMapper.saveOrder(order);
			
			//获取订单主键的值
			int orderId = order.getId();
			for(OrderItem item : items) {
				item.setOrderId(orderId);
				//保存订单明细
				orderItemMapper.saveItem(item);
			}
			
			
			/*****************************生成支付二维码*******************************/
			DataJoinUtils dataJoinUtils = new DataJoinUtils();

			Map<String, String> result =  dataJoinUtils.wxPay("http://localhost:8080/ecShop/article/index", order.getOrderCode(), "1", "127.0.0.1", "化妆品");
			//将二维码地址封装至order对象中
			order.setImgUrl(result.get("code_url"));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

       return order;
		
	}

	/* (non-Javadoc)
	 * @see com.longIt.shoppingApp.service.OrderServiceI#getOrdersByUserId()
	 * 根据当前用户的id查询，该用户所有的订单信息
	 */
	@Override
	public List<Order> getOrdersByUserId() {
		// TODO Auto-generated method stub
		//获取当前用户的信息
		//获取session
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		
		//从session中获取用户信息
		int userId = ((User)session.getAttribute("session_user")).getId();
		
		
		return orderMapper.getOrdersByUserId(userId);
	}

	//修改订单状态
	@Override
	public void updateOrderPayOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		orderMapper.updateOrderPayOrderNo(orderNo);
	}
	
	
	
	
}
