package com.tasly.account.db.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by dulei on 18/1/10.
 */
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long uid;

    /**
     * 账户剩余金额
     */
    private BigDecimal totalMoney;
}
