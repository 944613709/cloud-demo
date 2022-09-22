package cn.itcast.order.service;
import client.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pojo.User;

@Service
public class OrderService {
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderMapper orderMapper;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        String url = "http://localhost:8081/user/" +  order.getUserId();
//        User user = restTemplate.getForObject(url,User.class);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }

    public void queryGoods()
    {
        System.err.println("查询商品");
    }
}
