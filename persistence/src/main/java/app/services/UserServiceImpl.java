package app.services;

import app.models.User;
import app.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService
{
    public UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id)
    {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user)
    {
        userRepository.delete(user);
    }
}
