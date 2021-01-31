package com.less.provider.service.impl;


import com.less.provider.bean.UserAddress;

import java.util.List;

public interface UserSvc {
    public List<UserAddress> getUserAddressList(String userId);
}
