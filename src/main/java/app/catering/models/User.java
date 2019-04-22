package app.catering.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private @NotNull String first_name;

    private @NotNull String last_name;

    private @NotNull String email;

    private @NotNull String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date created;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", columnDefinition = "int default 1")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchases;

    @Builder
    public User(Long id, @NotNull String first_name, @NotNull String last_name, @NotNull String email, @NotNull String password, @NotNull Role role)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
