package com.api.repository.orm;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import com.api.entity.enumerable.UserRole;

import java.util.List;

@Document(value = "User")
public record UserOrmMongo(
    @Id
    String id,
    @Indexed
    String username,
    String email,
    String password,
    List<UserRole> roles

){}
