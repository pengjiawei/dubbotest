package com.iflyvoice.provider;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by pengjiawei on 2016/9/30.
 */

public class StartProvider {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("dubbo-provider.xml").start();
        Logger.getLogger("provider").info("dubbo-provider服务启动,启动startconsumer试试");
        Logger.getLogger("provider").info("这里是provider，按任意键退出...");

        //为保证服务一直开着，使用输入流来模拟进行阻塞
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
