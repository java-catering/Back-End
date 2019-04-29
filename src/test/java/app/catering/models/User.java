package app.catering.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String first_name;

    private @NotNull String last_name;

    private @NotNull String password;

    private @NotNull String email;

    @CreatedDate
    private @NotNull Date date_created;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Role role_id;
}
