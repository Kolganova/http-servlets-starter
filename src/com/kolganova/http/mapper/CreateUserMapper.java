package com.kolganova.http.mapper;

import com.kolganova.http.dto.CreateUserDto;
import com.kolganova.http.entity.Gender;
import com.kolganova.http.entity.Role;
import com.kolganova.http.entity.User;
import com.kolganova.http.util.LocalDateFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper implements Mapper <CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
