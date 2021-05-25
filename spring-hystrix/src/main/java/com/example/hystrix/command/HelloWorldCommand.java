package com.example.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhigang.peng
 * @date 2021/5/25
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private String name;

    protected HelloWorldCommand(String name) {
        // 指定命令组名
        super(HystrixCommandGroupKey.Factory.asKey("exampleKey"));
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // 同步执行
//        syncExecute();
        // 异步执行
//        asyncExecute();

        // 回调
        callback();

    }


    public static void callback() {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("World");
        Observable<String> fs = new HelloWorldCommand("World").observe();
        // 注册回调事件
        fs.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                // 执行处理结果 result 为HelloWorldCommand返回的结果
                // 用户对结果做二次处理
                System.out.println("使用事件的订阅的方式对结果进行订阅：" + s);
            }
        });

//        helloWorldCommand.execute();

        // 注册完整执行生命周期事件
        fs.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError " + e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                // 获取结果回调
                System.out.println("onNext: " + s);
            }
        });

//        helloWorldCommand.execute();

    }

    private static void syncExecute() throws InterruptedException, ExecutionException, TimeoutException {
        // 创建命令 每个命令只能执行一次 不能重复执行
        // 重复执行 This instance can only be executed once. Please instantiate a new instance. 如何做到不能重复执行
        // 命令本身提供执行的逻辑
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");
        // 同步执行
//        String result = helloWorldCommand.execute();
//        System.out.println("result=" + result);

        // 同步执行的效果等同于
//        String result = helloWorldCommand.queue().get();
        // 使用异步调用
        Future<String> future = helloWorldCommand.queue();
        // get操作不能超过command定义的超过时间 默认：秒
        String result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result=" + result);

        System.out.println("mainThread=" + Thread.currentThread().getName());
    }

    public static void asyncExecute() throws InterruptedException, ExecutionException, TimeoutException {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommand.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        String result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result=" + result);
        System.out.println("mainThread=" + Thread.currentThread().getName());
    }

    /**
     * 主要逻辑封装在run方法中
     *
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        return "Hello " + name + " thread:" + Thread.currentThread().getName();
    }
}
