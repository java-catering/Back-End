package app.config;

import app.models.Role;
import app.models.User;
import app.services.RoleService;
import app.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Bootstrap implements CommandLineRunner
{

    private final UserService userService;
    private final RoleService roleService;
    private Role ADMIN;
    private Role USER;

    public Bootstrap(UserService userService, RoleService roleService)
    {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void setUp()
    {
        USER = roleService.findById(1L);
        ADMIN = roleService.findById(2L);
    }

    // we will add all our mock users and purchases here.
    @Override
    public void run(String... args) throws Exception
    {

        User eric = new User().builder()
                .first_name("Eric")
                .last_name("Gomez")
                .email("eric@example.com")
                .password("123")
                .role(ADMIN)
                .build();


    }
}
