package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "purchase_products")
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

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Purchase_Product> purchase_products = new HashSet<>();

}
