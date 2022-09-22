package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/update")
    public String updateOrder()
    {
        return "更新成功";
    }

    @GetMapping("/query")
    public String queryOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "查询订单成功";
    }
}
