package user.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.resilience.annotation.RetryAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import user.service.model.dto.ProductDto;
import user.service.model.dto.ProductRelationDto;
import user.service.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestServiceImpl implements RestService
{

    private final UserRepository userRepository;

    public List<ProductDto> readActiveProduct(UUID id) {

            RestTemplate restTemplate = new RestTemplate();
            String productsUrl = "http://localhost:8081/products/{userId}";
            return restTemplate.exchange(
                    productsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDto>>(){}, id).getBody();
        }

    public ResponseEntity<?> createRelation(ProductRelationDto userProductRelations) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String productsUrl = "http://localhost:8081/userRelations";
            return restTemplate.postForEntity(productsUrl, userProductRelations, UUID.class);
        } catch (HttpServerErrorException e) {
           return new ResponseEntity<>(e.getStatusCode());
        }
    }

    public int deleteRelation(UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        String productsUrl = "http://localhost:8081/userRelations/{id}";

        return restTemplate.exchange(
                productsUrl, HttpMethod.DELETE, null, ResponseEntity.class, id).getStatusCode().value();
   }

}
