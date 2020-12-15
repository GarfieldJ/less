package com.less.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Alive {

    @RequestMapping(value = "/alive")
    public String isAlive() {
        return "Hello world!";
    }
}
