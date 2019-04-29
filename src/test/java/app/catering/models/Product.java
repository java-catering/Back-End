package app.catering.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private @NotNull String product_name;

    private @NotNull Double unit_price;
}
