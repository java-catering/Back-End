package app.catering.models;

import lombok.Data;

import javax.persistence.*;
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

    private @NotNull String title;

    @NotNull
    @Min(0)
    @Column(columnDefinition = "DECIMAL(8, 2)")
    private Double unit_price;

    private String description;

    private @NotNull Boolean is_available;

    // this property will provide a reference for the manyToMany in
    // the purchase file but wont create an extra table
    @ManyToMany(mappedBy = "products")
    private Set<Purchase> purchases;

}
