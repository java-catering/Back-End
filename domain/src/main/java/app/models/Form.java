package app.models;

import lombok.Data;

@Data
public class Form
{
    private String email;
    private String password;

    public Form(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
}
