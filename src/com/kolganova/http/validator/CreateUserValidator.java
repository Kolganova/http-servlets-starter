package com.kolganova.http.validator;

import com.kolganova.http.dto.CreateUserDto;
import com.kolganova.http.entity.Gender;
import com.kolganova.http.entity.Role;
import com.kolganova.http.util.LocalDateFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.getGender() == null || Objects.equals(Gender.find(object.getGender()),Optional.empty())) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (Objects.equals(Role.find(object.getRole()),Optional.empty())) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if(!EmailValidator.getInstance().isValid(object.getEmail())) {
            validationResult.add(Error.of("invalid.email", "Email is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
