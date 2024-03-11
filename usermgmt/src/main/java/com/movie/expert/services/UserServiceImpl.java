package com.movie.expert.services;

import com.movie.expert.daos.UserDAO;
import com.movie.expert.models.RegistrationRequest;
import com.movie.expert.models.RegistrationResponse;
import com.movie.expert.models.User;
import com.movie.expert.models.exceptions.UniquenessException;
import com.movie.expert.models.exceptions.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder encoder;
    private final Validator validator;

    @Override
    public RegistrationResponse register(RegistrationRequest request) throws ValidationException, UniquenessException {
        validateRequest(request);
        checkUserUniqueness(request);
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        CharSequence encPassword = encoder.encode(request.getPassword());
        newUser.setPassword(encPassword.toString());
        newUser.setEmail(request.getEmail());
        userDAO.register(newUser);
        return new RegistrationResponse(true);
    }

    private void validateRequest(RegistrationRequest request) throws ValidationException {
        Set<ConstraintViolation<RegistrationRequest>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("User validation failed: ");
            for (ConstraintViolation<RegistrationRequest> violation : violations) {
                errorMessage.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException(errorMessage.toString());
        }
    }

    private void checkUserUniqueness(RegistrationRequest request) throws UniquenessException {
        boolean isUsernameExists = userDAO.checkUserExistsByUsername(request.getUsername());
        boolean isEmailExists = userDAO.checkUserExistsByEmail(request.getEmail());
        if (isEmailExists) {
            throw new UniquenessException("Email is already registered: " + request.getEmail());
        } else if (isUsernameExists) {
            throw new UniquenessException("Username is already registered: " + request.getUsername());
        }
    }
}
