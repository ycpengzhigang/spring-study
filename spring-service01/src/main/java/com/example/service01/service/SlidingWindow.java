package com.example.service01.service;

import java.util.LinkedList;

/**
 * 服务每s能处理的请求 100个请求 将时间进行s/定义为时间窗 对1划分为10个格 平均每个时间格为100ms
 *
 * @author zhigang.peng
 * @date 2021/6/29
 */
public class SlidingWindow {

    /**
     * 请求计数器 由外部进行处理
     */
    private long counter = 0;

    /**
     * 请求限制
     */
    private int limit = 100;

    /**
     * 划分的时间窗格为10个
     */
    private int split = 10;
    /**
     * 时间窗格
     */
    private LinkedList<Long> slots = new LinkedList<>();

    /**
     * 是否被限流了
     */
    private boolean isLimit = false;

    public void doCheck() throws InterruptedException {
        while (true) {
            slots.addLast(counter);
            if (slots.size() > split) {
                // 移除第一个元素
                slots.removeFirst();
            }
            // 在时间窗内请求的数量没有超过限制
            if (slots.peekLast() - slots.peekFirst() < limit) {
                isLimit = false;
            } else {
                isLimit = true;
            }

            Thread.sleep(1000 / 10);
        }
    }

}
