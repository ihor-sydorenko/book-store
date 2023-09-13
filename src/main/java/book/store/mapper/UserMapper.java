package book.store.mapper;

import book.store.config.MapperConfig;
import book.store.dto.request.UserRegistrationRequestDto;
import book.store.dto.response.UserRegistrationResponseDto;
import book.store.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserRegistrationResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto requestDto);
}
