package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 高希阳
 * @Date: 2018/9/19 11:40
 * @Description:
 */
@RestController
@RequestMapping(value = "first")
public class HelloController {

    protected static Logger logger= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello/{Name}")
    public String hellName(@PathVariable("Name") String myName){
        logger.info("访问helloName,Name={}",myName);
        return "Hello "+myName;
    }
}
