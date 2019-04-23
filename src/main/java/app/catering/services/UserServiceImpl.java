package app.catering.services;

import app.catering.models.User;
import app.catering.repositorys.UserRepository;

import java.util.List;
import java.util.Optional;

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
