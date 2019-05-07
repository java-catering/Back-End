package app.DAO_models;


import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterForm extends Form
{
    private @NotNull String first_name;
    private @NotNull String last_name;

    @Builder
    public RegisterForm(String first_name, String last_name, String email, String password)
    {
        super(email, password);
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
