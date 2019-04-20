package app.catering.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "role")
    private Set<User> users;
}
