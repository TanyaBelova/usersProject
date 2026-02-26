package user.service.service;

import user.service.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    /**
     * Создает нового пользователя
     * @param user - клиент для создания
     */
    void create(User user);

    /**
     * Возвращает список всех имеющихся пользователей
     * @return список пользователей
     */
    List<User> readAll();

    /**
     * Возвращает пользователя по его ID
     * @param id - ID пользователя
     * @return - объект пользователя с заданным ID
     */
    User read(UUID id);

    /**
     * Обновляет пользователя с заданным ID,
     * в соответствии с переданным пользователем
     * @param user - пользователь, в соответствии с которым нужно обновить данные
     * @param id - id пользователя, которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(User user, UUID id);

    /**
     * Удаляет пользователя с заданным ID
     * @param id - id пользователя, которого нужно удалить
     * @return - true если пользователь был удален, иначе false
     */
    boolean delete(UUID id);
}