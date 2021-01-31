package com.less.core.service;


import com.less.core.model.annotations.bean.UserAddress;

import java.util.List;

public interface IOrderService {
    public List<UserAddress> initOrder(String userId);
}
