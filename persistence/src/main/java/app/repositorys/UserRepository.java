package app.repositorys;

import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Query(value = "DELETE FROM user WHERE :id = user.id",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Query(value = "SELECT * from user WHERE :email = user.email", nativeQuery = true)
    Optional<User> findUserByEmail(@Param("email") String email);
}
