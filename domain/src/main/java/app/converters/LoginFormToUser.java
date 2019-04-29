package app.converters;

import app.DAO_models.LoginForm;
import app.models.User;

public class LoginFormToUser
{
    public static User convert(LoginForm form)
    {
        User user = new User();

        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());

        return user;
    }
}
