package app.repositorys;

import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Query(value = "DELETE FROM user WHERE :id = user.id",nativeQuery = true)
    void deleteById(@Param("id") Long id);
}
