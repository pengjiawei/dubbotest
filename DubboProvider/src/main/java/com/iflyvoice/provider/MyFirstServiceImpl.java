package com.iflyvoice.provider;

import com.iflyvoice.service.MyFirstService;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.logging.Logger;

/**
 * Created by pengjiawei on 2016/9/30.
 */

public class MyFirstServiceImpl implements MyFirstService {

    public void sayHello() {
        Logger.getLogger("").info("Hello,Everybody!I am the provider");
    }
}
