package user.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.service.mapper.UserMapper;
import user.service.model.dto.ProductDto;
import user.service.model.dto.ProductRelationDto;
import user.service.model.dto.UserDto;
import user.service.model.entity.User;
import user.service.service.RestService;
import user.service.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
// говорит спрингу, что данный класс является REST контроллером.
// Т.е. в данном классе будет реализована логика обработки клиентских запросов
@RequiredArgsConstructor
public class UserController {

    private final UserService userService; // что это
    private final RestService restService;
    private final UserMapper userMapper;

    // данный метод обрабатывает POST запросы на адрес /users
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        System.out.println("2..");
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    // данный метод обрабатывает GET запросы на адрес /users
    public ResponseEntity<List<UserDto>> readAll() {
        var usersDtoList = userMapper.toUserDtoList(userService.readAll());

        return usersDtoList != null &&  !usersDtoList.isEmpty()
                ? new ResponseEntity<>(usersDtoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> read(@PathVariable(name = "id") UUID id) {
        var userDto = userMapper.toUserDto(userService.read(id));

        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody User user) {
        final boolean updated = userService.update(user, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/userProducts/{userId}")
    public ResponseEntity<List<ProductDto>> readActiveProduct(@PathVariable(name = "userId") UUID userId) {
        final List<ProductDto> products = restService.readActiveProduct(userId);

        return products != null &&  !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/userProductsRelation")
    public ResponseEntity<?> createRelation(@RequestBody ProductRelationDto userProductRelations) {

        ResponseEntity<?> created = restService.createRelation(userProductRelations);
        return created;

    }

    @DeleteMapping(value = "/userProductsRelation/{id}")
    public ResponseEntity<?> deleteRelation(@PathVariable(name = "id") UUID id) {

        if(restService.deleteRelation(id)==200){
        return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
