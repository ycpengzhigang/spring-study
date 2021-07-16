package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinel.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhigang.peng
 * @date 2021/6/30
 */
@RestController("/order")
public class OrderController {


    @GetMapping("getOrderInfo")
    // 指定资源名称
    @SentinelResource(value = "getOrderInfo", blockHandler = "getOrderInfoHandler", fallback = "getOrderInfoFallback")
    public OrderDto getOrderInfo(String orderNo) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAmount(new BigDecimal(12));
        orderDto.setOrderNo(orderNo);
        return orderDto;
    }

    /**
     * 超过了流量限制 进行订单信息的处理
     *
     * @param orderNo
     * @param ex
     * @return
     */
    public OrderDto getOrderInfoHandler(String orderNo, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return null;
    }

    /**
     * 出现异常时的处理
     *
     * @param orderNo
     * @return
     */
    public OrderDto getOrderInfoFallback(String orderNo) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderNo(orderNo);
        orderDto.setAmount(new BigDecimal(0));
        return orderDto;
    }

}
