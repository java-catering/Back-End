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

    @Min(3)
    @Max(25)
    @NotNull
    private String title;

    @NotNull
    @Min(0)
    @Column(columnDefinition = "DECIMAL(8, 2)")
    private Double unit_price;

    private String description;

    private @Min(0) @NotNull Integer stock;


    private @Enumerated(value = EnumType.STRING) Color color;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    // this property will provide a reference for the manyToMany in
    // the purchase file but wont create an extra table
    @ManyToMany(mappedBy = "products")
    private Set<Purchase> purchases;

}
