package com.xsx.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/7 0007 15:23
 */
@Controller
public class HelloController {

    @GetMapping("/user")
    public String user(){
        return "user";
    }
}
