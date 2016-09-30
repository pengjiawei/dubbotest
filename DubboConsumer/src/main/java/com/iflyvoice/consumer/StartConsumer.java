package com.iflyvoice.consumer;

import com.iflyvoice.service.MyFirstService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

/**
 * Created by pengjiawei on 2016/9/30.
 */
public class StartConsumer {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();


        Logger.getLogger("consumer").info("dubbo-consumer启动，调用service中的方法");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        final String name1 = "1号pengjiawei";
        final String name2 = "2号pengjiawei";
        final String name3 = "3号pengjiawei";
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //感觉这个获取的办法好笨，应该可以用注释获取的
                    MyFirstService myFirstService = (MyFirstService) context.getBean("MyFirstService");
                    Logger.getLogger("").info("Thread1----->"+Thread.currentThread());
                    myFirstService.sayHello(name1);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //感觉这个获取的办法好笨，应该可以用注释获取的
                    MyFirstService myFirstService = (MyFirstService) context.getBean("MyFirstService");
                    Logger.getLogger("").info("Thread2----->"+Thread.currentThread());
                    myFirstService.sayHello(name2);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //感觉这个获取的办法好笨，应该可以用注释获取的
                    MyFirstService myFirstService = (MyFirstService) context.getBean("MyFirstService");
                    Logger.getLogger("").info("Thread3----->"+Thread.currentThread());
                    myFirstService.sayHello(name3);
                }
            }
        }.start();


        Logger.getLogger("consumer").info("这里是consumer，按任意键退出...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
