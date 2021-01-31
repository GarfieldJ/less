package com.less.core.controller;

import com.less.core.model.annotations.exception.SelfException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Alive {

    /* 使用thymeleaf不能用@ResponseBody */
    @RequestMapping(value = "/alive")
    public String isAlive() {
        return "alive";
    }

    /* 使用thymeleaf不能用@ResponseBody */
    @RequestMapping(value = "/testerror")
    public String testError() {
        throw new SelfException("error");
    }
}
