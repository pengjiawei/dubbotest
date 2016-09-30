package com.iflyvoice.provider;

import com.iflyvoice.service.MyFirstService;

import org.apache.log4j.Logger;

/**
 * Created by pengjiawei on 2016/9/30.
 */

public class MyFirstServiceImpl implements MyFirstService {

    public void sayHello(String name) {
        Logger.getLogger("").info("Hello,Everybody!I am in the provider");
        Logger.getLogger("").info("My name is "+ name);
    }
}
