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

    @OneToMany(mappedBy = "product")
    private Set<Purchase_Product> purchase_products;

}
