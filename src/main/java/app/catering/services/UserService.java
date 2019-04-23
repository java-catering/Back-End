package app.catering.services;

import app.catering.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void delete(User user);

    void deleteById(Long id);
}
