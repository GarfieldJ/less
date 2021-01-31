package com.less.core.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.less.core.model.annotations.bean.UserAddress;
import com.less.core.service.IOrderService;
import com.less.core.service.UserSvc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Reference(check = false, timeout = 1000, retries = 2, loadbalance = "random", mock = "fail:return+null")
    UserSvc usersvc;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.printf("用户id: %s", userId);
        return usersvc.getUserAddressList(userId);
    }
}
