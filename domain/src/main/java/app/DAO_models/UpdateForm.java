package app.DAO_models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateForm extends Form
{
    private String first_name;
    private String last_name;

    public UpdateForm(String first_name, String last_name, String email, String password)
    {
        super(email, password);
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
