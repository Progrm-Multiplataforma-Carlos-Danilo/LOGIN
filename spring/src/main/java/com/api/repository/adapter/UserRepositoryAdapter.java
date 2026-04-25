package com.api.repository.adapter;


import com.api.entity.User;
import com.api.repository.orm.UserOrmMongo;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRepositoryAdapter {

    private UserRepositoryAdapter() {
    }

    public static User cast(UserOrmMongo orm) {
        return new User(
                orm.id(),
                orm.username(),
                orm.email(),
                orm.password(),
                orm.roles());
    }

    public static UserOrmMongo cast(User user, PasswordEncoder passwordEncoder) {
        return new UserOrmMongo(
                user.id(),
                user.username(),
                user.email(),
                passwordEncoder.encode(user.password()),
                user.roles());
    }

}