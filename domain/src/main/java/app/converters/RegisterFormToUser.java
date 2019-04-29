package app.converters;

import app.DAO_models.RegisterForm;
import app.models.User;

public class RegisterFormToUser
{
    public static User convert(RegisterForm  form)
    {
        User user = new User();

        user.setFirst_name(form.getFirst_name());
        user.setLast_name(form.getLast_name());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());

        return user;
    }
}
