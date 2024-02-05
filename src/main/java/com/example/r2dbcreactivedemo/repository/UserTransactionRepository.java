package com.example.r2dbcreactivedemo.repository;

import com.example.r2dbcreactivedemo.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction,Integer> {
}
