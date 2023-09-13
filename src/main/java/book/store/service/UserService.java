package book.store.service;

import book.store.dto.request.UserRegistrationRequestDto;
import book.store.dto.response.UserRegistrationResponseDto;
import book.store.exception.RegistrationException;

public interface UserService {
    UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException;
}
