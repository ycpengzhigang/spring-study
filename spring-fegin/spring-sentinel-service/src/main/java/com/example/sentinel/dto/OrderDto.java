package com.example.sentinel.dto;

import java.math.BigDecimal;

/**
 * @author zhigang.peng
 * @date 2021/6/30
 */
public class OrderDto {

    private String orderNo;

    private BigDecimal amount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
