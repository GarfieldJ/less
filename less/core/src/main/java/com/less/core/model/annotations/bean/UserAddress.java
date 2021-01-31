package com.less.core.model.annotations.bean;

import java.io.Serializable;

public class UserAddress implements Serializable {
    private String userId;
    private String phoneNum;


    public UserAddress() {
    }

    public UserAddress(String userId, String phoneNum) {
        this.userId = userId;
        this.phoneNum = phoneNum;
    }
}
