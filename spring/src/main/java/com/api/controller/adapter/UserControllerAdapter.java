package com.api.controller.adapter;

import com.api.controller.dto.request.UserRequest;
import com.api.entity.User;

import java.util.UUID;

public class UserControllerAdapter {
    private UserControllerAdapter() {
    }

    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.username(),
                request.email(),
                request.password(),
                request.roles());
    }

    public static User castUpdate(UserRequest request) {
        return new User(
                request.id(),
                request.username(),
                request.email(),
                request.password(),
                request.roles());
    }
}