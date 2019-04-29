package app.api.v1.controllers;

import app.converters.RegisterFormToUser;
import app.DAO_models.LoginForm;
import app.DAO_models.RegisterForm;
import app.models.User;
import app.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/client") //base end point
public class ClientController
{
    private final UserService userService;

    public ClientController(UserService userService)
    {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User registerClient(@RequestBody RegisterForm registerForm)
    {
        return userService.save(RegisterFormToUser.convert(registerForm));
    }

    @CrossOrigin
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public User updateClient(@RequestBody RegisterForm registerForm)
    {
        return userService.save(RegisterFormToUser.convert(registerForm));
    }

    @CrossOrigin
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User loginClient(@RequestBody LoginForm form)
    {
        User getUser = userService.findByEmail(form.getEmail());

        if (getUser.getPassword().equals(form.getPassword()))
        {
            log.error("User " + form.getEmail() + " Exists");
        }

        return getUser;
    }
}