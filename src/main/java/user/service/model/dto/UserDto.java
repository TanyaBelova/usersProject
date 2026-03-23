package user.service.model.dto;

import java.util.UUID;

public record UserDto(UUID id, String login, String email, String phone) {
}