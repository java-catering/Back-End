package app.services;

import app.models.Purchase_Product;

import java.util.Set;

public interface Purchase_ProductService
{
    Set<Purchase_Product> findAll();

    Purchase_Product findById(Long id);

    Purchase_Product save(Purchase_Product purchase_product);

    void delete(Purchase_Product purchase_product);

    void deleteById(Long id);
}
