package user.service.model.dto;

import java.util.Date;
import java.util.UUID;

public record ProductDto(UUID id, String name, Date creationDate, boolean active) { }
