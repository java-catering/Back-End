package app.catering.services;

import app.catering.repositorys.UserRepository;

public class UserServiceImpl implements UserService
{
    public UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }
}
