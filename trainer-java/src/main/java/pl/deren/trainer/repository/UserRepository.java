package pl.deren.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import pl.deren.trainer.DTO.UserDTO;
import pl.deren.trainer.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new pl.deren.trainer.DTO.UserDTO(u.id, u.name, u.surname, u.email, u.password, " +
            "ur.roleName, ud.phoneNumber, ud.sex, ud.createdAt, c.cityName) " +
            "FROM User u " +
            "JOIN u.userRole ur " +
            "JOIN u.userDetail ud " +
            "JOIN ud.city c")
    List<UserDTO> findAllUsersWithDetails();

    Optional<User> findByEmail(String email);
}
