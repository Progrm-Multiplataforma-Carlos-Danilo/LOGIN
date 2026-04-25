package com.api.repository.mongo;


import com.api.repository.orm.UserOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryWithMongoDB extends MongoRepository<UserOrmMongo, String> {
    Optional<UserOrmMongo> findByUsername(String username);
}