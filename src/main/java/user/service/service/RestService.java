package user.service.service;

import org.springframework.http.ResponseEntity;
import user.service.model.dto.ProductDto;
import user.service.model.dto.ProductRelationDto;

import java.util.List;
import java.util.UUID;

public interface RestService {

    /**
     * Возвращает список всех имеющихся у пользователя АКТИВНЫХ услуг
     * @return список АКТИВНЫХ услуг пользователя
     */
    List<ProductDto> readActiveProduct(UUID userId);

    /**
     * Создает связь пользователя с услугой
     */
    ResponseEntity<?> createRelation(ProductRelationDto userProductRelation);

    /**
     * Удвляет связь пользователя с услугой
     */
    int deleteRelation(UUID id);

}
