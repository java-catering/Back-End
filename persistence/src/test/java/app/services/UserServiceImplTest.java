package app.services;

import app.models.Role;
import app.models.User;
import app.repositorys.RoleRepository;
import app.repositorys.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest
{
    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final Long ROLEID = 1L;

    private final Long USERID = 1L;

    private List<User> users = new ArrayList<>();

    private final Role role = new Role().builder()
            .id(ROLEID)
            .name("admin")
            .build();

    private final User user = new User().builder()
                .id(USERID)
                .first_name("eric")
                .last_name("G")
                .email("Eric@Example.com")
                .password("123")
                .role(role)
                .build();

    @BeforeEach
    public void setUp()
    {
        users.add(user);
    }

    @AfterEach
    public void tearDown()
    {
        users = new ArrayList<>();
    }

    @Test
    void getAllUsers()
    {
        //when
        when(userService.findAll()).thenReturn(users);

        List<User> getUsers = userService.findAll();

        //then
        assertNotNull(getUsers);

        assertEquals(1, getUsers.size());
    }

    @Test
    void getUserById()
    {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User returnedUser = userService.findById(1L);

        assertNotNull(returnedUser);

        verify(userRepository,times(1)).findById(anyLong());
    }

    @Test
    void saveUser()
    {
        User newUser = new User().builder().first_name("e").last_name("g").email("e").password("123").build();

        when(userRepository.save(any())).thenReturn(user);
        when(roleRepository.findById(ROLEID)).thenReturn(Optional.of(role));

        User returnedUser = userService.save(newUser);

        assertEquals(Long.valueOf(USERID), Long.valueOf(returnedUser.getId()));

        assertEquals(ROLEID, returnedUser.getRole().getId());

        verify(userRepository, times(1)).save(any());
    }


    @Test
    void deleteById()
    {
        // when
        userService.deleteById(USERID);

        //then
        verify(userRepository).deleteById(anyLong());
    }

    @Test
    void delete()
    {
        userService.delete(user);

        verify(userRepository).delete(any());
    }
}