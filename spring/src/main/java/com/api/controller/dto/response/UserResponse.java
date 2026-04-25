package com.api.controller.dto.response;



import com.api.entity.enumerable.UserRole;

import java.util.List;

public record UserResponse (
        String id,
        String username,
        String email,
        String password,
        List<UserRole> roles
){
}
