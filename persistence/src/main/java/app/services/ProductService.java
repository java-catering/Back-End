package app.services;

import app.models.Product;

import java.util.List;

public interface ProductService
{
    Product save(Product product);

    Product saveAndReturnProducts(Product product);

    void delete(Product product);

    void deleteById(Long id);

    Product findById(Long id);

    List<Product> findAll();
}
