package com.kolganova.http.service;

import com.kolganova.http.dao.UserDao;
import com.kolganova.http.dto.CreateUserDto;
import com.kolganova.http.entity.User;
import com.kolganova.http.exception.ValidationException;
import com.kolganova.http.mapper.CreateUserMapper;
import com.kolganova.http.validator.CreateUserValidator;
import com.kolganova.http.validator.ValidationResult;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    public static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.INSTANCE;

    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDto userDto) {
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        User userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
