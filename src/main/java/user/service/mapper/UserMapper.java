package user.service.mapper;

import org.mapstruct.Mapper;
import user.service.model.dto.UserDto;
import user.service.model.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user); //map User to UserResponse

    List<UserDto> toUserDtoList(List<User> users);
}