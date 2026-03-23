package user.service.model.dto;

import java.util.UUID;

public record ProductRelationDto(UUID id, UUID userId, UUID productId) {}