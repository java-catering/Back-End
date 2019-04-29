package app.models;


import lombok.Data;

@Data
public class RegisterForm extends Form
{
    private String first_name;
    private String last_name;

    public RegisterForm(String first_name, String last_name, String email, String password)
    {
        super(email, password);
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
