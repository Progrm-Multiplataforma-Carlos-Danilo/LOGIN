package com.api.controller.dto.request;

import com.api.entity.enumerable.UserRole;

import java.util.List;

public record UserRequest (
        String id,
        String username,
        String email,
        String password,
        List<UserRole> roles
){
}
