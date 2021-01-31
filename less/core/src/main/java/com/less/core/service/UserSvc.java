package com.less.core.service;



import com.less.core.model.annotations.bean.UserAddress;

import java.util.List;

public interface UserSvc {
    public List<UserAddress> getUserAddressList(String userId);
}
