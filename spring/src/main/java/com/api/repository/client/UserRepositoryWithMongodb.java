package com.api.repository.client;

import com.api.repository.orm.UserOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryWithMongodb extends MongoRepository<UserOrmMongo, String> {
    Optional<UserOrmMongo> findByUsername(String username);
}
