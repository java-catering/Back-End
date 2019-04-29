package app.services;

import app.models.Role;
import app.models.User;
import app.repositorys.RoleRepository;
import app.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final Long ADMINID = 2L;
    private final Long CLIENTID = 1L;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email)
    {
        Optional<User> userOptional = userRepository.findUserByEmail(email);

        if (!userOptional.isPresent())
        {
            throw new RuntimeException("user does not exist, find by email.");
        }

        return userOptional.get();
    }

    @Override
    public User findById(Long id)
    {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
        {
            throw new RuntimeException("no user found by ID.");
        }

        return userOptional.get();
    }

    @Override
    public User save(User user)
    {
        Optional<Role> role = roleRepository.findById(CLIENTID);

        if (!role.isPresent())
        {
            throw new RuntimeException();
        }

        user.setRole(role.get());

        return userRepository.save(user);

    }

    @Override
    public User saveAdmin(User user)
    {
        Optional<Role> role = roleRepository.findById(ADMINID);

        if (!role.isPresent())
        {
            throw new RuntimeException("no Admin role found");
        }

        user.setRole(role.get());

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
