package app.api.v1.controllers;

import app.DAO_models.UpdateForm;
import app.converters.UpdateFormToUser;
import app.DAO_models.LoginForm;
import app.models.User;
import app.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin") // base endpoints
public class AdminController
{
    private UserService userService;

    public AdminController(UserService userService)
    {
        this.userService = userService;
    }

    // login
    @CrossOrigin
    @PostMapping({"/login", "/"})
    @ResponseStatus(HttpStatus.OK)
    public User loginAdmin(@RequestBody LoginForm loginForm)
    {
        User user = userService.findByEmail(loginForm.getEmail());
        if (user.getPassword().equals(loginForm.getPassword()))
        {
            return user;
        }
        return null;
    }

    // update
    @CrossOrigin
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public User updateAdmin(@RequestBody UpdateForm updateForm)
    {
        User user = userService.findByEmail(updateForm.getEmail());

        return userService.saveAdmin(UpdateFormToUser.convert(updateForm, user));
    }
}
