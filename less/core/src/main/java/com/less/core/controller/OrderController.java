package com.less.core.controller;

import com.less.core.model.annotations.bean.UserAddress;
import com.less.core.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("userId") String userId) {
        return orderService.initOrder(userId);

    }

}
