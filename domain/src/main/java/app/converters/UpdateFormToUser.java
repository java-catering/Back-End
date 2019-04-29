package app.converters;

import app.DAO_models.UpdateForm;
import app.models.User;

public class UpdateFormToUser
{
    public static User convert(UpdateForm updateForm, User updatedUser)
    {
        if (updateForm.getEmail() != null)
        {
            updatedUser.setEmail(updateForm.getEmail());
        }
        if (updateForm.getPassword() != null)
        {
            updatedUser.setPassword(updateForm.getPassword());
        }
        if (updateForm.getFirst_name() != null)
        {
            updatedUser.setFirst_name(updateForm.getFirst_name());
        }
        if (updateForm.getLast_name() != null)
        {
            updatedUser.setLast_name(updateForm.getLast_name());
        }

        return updatedUser;
    }
}
