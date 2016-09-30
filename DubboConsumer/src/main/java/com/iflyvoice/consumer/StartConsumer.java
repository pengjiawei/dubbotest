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

        //感觉这个获取的办法好笨，应该可以用注释获取的
        MyFirstService myFirstService = (MyFirstService) context.getBean("MyFirstService");
        Logger.getLogger("consumer").info("dubbo-consumer启动，调用service中的方法");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        myFirstService.sayHello();
        Logger.getLogger("consumer").info("这里是consumer，按任意键退出...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
