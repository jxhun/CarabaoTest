package com.jxhun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/04/08
 * Description:
 * Version: V1.0
 */
@SpringBootApplication
public class SpringbootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        // 此行代码是为了标识哪一个类作为springboot的入口
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootApplication.class);
    }
}
