package com.tasly.order.db.reposity;

import com.tasly.order.db.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface OrderReposity extends JpaRepository<Order,Long> {

}
