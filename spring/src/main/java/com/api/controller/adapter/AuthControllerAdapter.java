package com.api.controller.adapter;

import com.api.controller.dto.request.LoginRequest;
import com.api.entity.Login;


public class AuthControllerAdapter {
    private AuthControllerAdapter() {
    }

    public static Login cast(LoginRequest request) {
        return new Login(request.username(), request.password());
    }
}