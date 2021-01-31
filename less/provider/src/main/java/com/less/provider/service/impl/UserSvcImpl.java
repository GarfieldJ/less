package com.less.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.less.provider.bean.UserAddress;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service(weight = 100)  // 暴露服务
@Component
public class UserSvcImpl implements UserSvc {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress a1 = new UserAddress("11",  "1");
        UserAddress a2 = new UserAddress("22",  "2");


        return Arrays.asList(a1, a2);
    }
}
