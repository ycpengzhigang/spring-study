package com.example.service01.service;

import java.util.LinkedList;
import java.util.Random;

/**
 * 滑动时间窗口限流实现
 * 假设某一个服务最多只能每秒钟处理100请求 我们设置一个1秒钟的滑动时间窗口
 * 窗口中有10个格子，每个格子100ms 每一100ms移动一次 每次移动都需要记录当前服务请求的次数
 *
 * @author zhigang.peng
 * @date 2021/6/29
 */
public class SlidingTimeWindow {

    /**
     * 时间窗口内最大的请求数
     */
    static final int limit = 100;

    /**
     * 服务访问的次数
     */
    long counter = 0L;

    /**
     * 使用linkedList来记录滑动窗口的10个格子
     */
    LinkedList<Long> slots = new LinkedList<>();

    /**
     * 时间划分为多少个段落
     */
    int split = 10;

    /**
     * 是否限流了 true :限流了 false：允许正常访问
     */
    boolean isLimit = false;


    public static void main(String[] args) throws InterruptedException {
        SlidingTimeWindow slidingTimeWindow = new SlidingTimeWindow();

        // 启动一个线程去判断当前的限流情况
        new Thread(() -> {
            try {
                slidingTimeWindow.doCheck();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        // 模拟请求
        while (true) {
            if (!slidingTimeWindow.isLimit) {
                slidingTimeWindow.counter++;
                Thread.sleep(new Random().nextInt(15));
            } else {
                System.out.println("被限流了。。。。。");
            }
        }
    }

    /**
     * 检测机制通过线程去启动
     *
     * @throws InterruptedException
     */
    public void doCheck() throws InterruptedException {
        while (true) {
            slots.addLast(counter);
            // slot的大小如果大于 说明该1s中并未超过最大请求数
            if (slots.size() > split) {
                // 移动100ms 移除首个
                slots.removeFirst();
            }
            if (slots.peekLast() - slots.peekFirst() > limit) {
                System.out.println("限流了...");
                isLimit = true;
            } else {
                isLimit = false;
            }
            Thread.sleep(1000 / split);
        }
    }
}
