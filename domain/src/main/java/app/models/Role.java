package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "role")
    private Set<User> users;

    @Builder
    public Role(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
