package com.tasly.order.db.domain;

import com.tasly.order.db.status.OrderStatus;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String sku;

    private String name;

    private BigDecimal price;

    private OrderStatus orderStatus;
}
