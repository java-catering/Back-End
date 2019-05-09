package app.DAO_models;

import app.models.Purchase_Product;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Purchase_Product_List
{
    Set<Purchase_Product> purchase_product_list = new HashSet<>();
}
