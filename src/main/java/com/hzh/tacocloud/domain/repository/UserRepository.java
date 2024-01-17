package com.hzh.tacocloud.domain.repository;

import com.hzh.tacocloud.domain.entity.User;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findByUsername(String name);
}
