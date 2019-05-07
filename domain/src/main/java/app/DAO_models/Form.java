package app.DAO_models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Form
{
    private @NotNull String email;
    private @NotNull String password;

    public Form(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
}
