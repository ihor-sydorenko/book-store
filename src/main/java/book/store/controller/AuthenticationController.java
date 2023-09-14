package book.store.controller;

import book.store.dto.request.UserLoginRequestDto;
import book.store.dto.request.UserRegistrationRequestDto;
import book.store.dto.response.UserLoginResponseDto;
import book.store.dto.response.UserRegistrationResponseDto;
import book.store.exception.RegistrationException;
import book.store.security.AuthenticationService;
import book.store.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping(value = "/register")
    public UserRegistrationResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }
}
