package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Purchase_Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    public void setProduct(Product product)
    {
        this.product = product;

        product.getPurchase_products().add(this);

    }

    public void setPurchase(Purchase purchase)
    {
        this.purchase = purchase;

        purchase.getPurchase_products().add(this);
    }

}
