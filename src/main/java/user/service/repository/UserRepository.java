package user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.service.model.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
