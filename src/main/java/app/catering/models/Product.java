package app.catering.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @Min(3) @Max(25) @NotNull String title;

    private @NotNull @Min(0) Double unit_price;

    private @NotNull Boolean is_stocked;

    @ManyToMany(mappedBy = "products")
    private Set<Purchase> purchases;

}
