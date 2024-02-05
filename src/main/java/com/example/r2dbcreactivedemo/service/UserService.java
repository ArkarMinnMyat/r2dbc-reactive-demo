package com.example.r2dbcreactivedemo.service;

import com.example.r2dbcreactivedemo.dto.UserDto;
import com.example.r2dbcreactivedemo.repository.UserRepository;
import com.example.r2dbcreactivedemo.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Flux<UserDto> all(){
        return userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> getUserById(final int userId){
        return userRepository.findById(userId)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono){
        return userDtoMono.map(EntityDtoUtil::toEntity)
                .flatMap(userRepository::save)
                .map(EntityDtoUtil::toDto);
    }
    public Mono<Void> deleteUser(int id){
        return userRepository.deleteById(id);
    }
}
