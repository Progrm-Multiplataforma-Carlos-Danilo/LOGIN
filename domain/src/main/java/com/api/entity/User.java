package com.api.entity;

import com.api.entity.enumerable.UserRole;

import java.util.List;

public record User(
        String id,
       String username,
        String email,
       String password,

       List<UserRole> roles
)
{
}
