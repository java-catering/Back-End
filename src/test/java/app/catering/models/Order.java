package app.catering.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NotNull Long id;

    @CreatedDate
    private @NotNull Date order_date;

    private @NotNull Double total_amount;

    @NotNull
    @ManyToOne
    @JoinColumn (name="user_id")
    private Long user_id;

    @NotNull
    @OneToMany
    @JoinTable
            (
                name="order_product",
                joinColumns = @JoinColumn (name="order_id"),
                    inverseJoinColumns =  @JoinColumn (name="product_id")
            )
    private Set <Product> products = new HashSet<>();
}
