package com.example.r2dbcreactivedemo.repository;

import com.example.r2dbcreactivedemo.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
