package com.example.r2dbcreactivedemo.util;

import com.example.r2dbcreactivedemo.dto.TransactionRequestDto;
import com.example.r2dbcreactivedemo.dto.TransactionResponseDto;
import com.example.r2dbcreactivedemo.dto.TransactionStatus;
import com.example.r2dbcreactivedemo.dto.UserDto;
import com.example.r2dbcreactivedemo.entity.User;
import com.example.r2dbcreactivedemo.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityDtoUtil {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto){
        UserTransaction ut = new UserTransaction();
        ut.setUserId(requestDto.getUserId());
        ut.setAmount(requestDto.getAmount());
        ut.setLocalDateTime(LocalDateTime.now());
        return ut;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status){
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }
}
