package com.tasly.order.core;

import com.tasly.order.core.api.OrderService;
import com.tasly.order.db.domain.Order;
import com.tasly.order.db.reposity.OrderReposity;
import com.tasly.order.db.status.OrderStatus;
import com.tasly.score.core.api.TCCScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by dulei on 18/1/9.
 */
@RestController
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TCCScoreService tccScoreService;

    @Autowired
    private OrderReposity orderReposity;

    @Override
    public String placeOrder(Integer score, String sku) {
        Order order = new Order();
        order.setName("产品名称");
        order.setPrice(new BigDecimal("2.9"));
        order.setSku(sku);
        order.setOrderStatus(OrderStatus.PAYING);

        tccScoreService.reduceScore(3);//TODO tcc



        order.setOrderStatus(OrderStatus.CONFITRM);

//        return orderReposity.save(order).toString();

        return "";
    }
}
