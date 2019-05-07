package app.services;

import app.models.Product;
import app.repositorys.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product)
    {
        return productRepository.save(product);
    }

    @Override
    public Product saveAndReturnProducts(Product product)
    {
        return productRepository.saveAndReturnProducts(product);
    }

    @Override
    public void delete(Product product)
    {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id)
    {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id)
    {
        Optional<Product> productOptional = productRepository.findById(id);

        if(!productOptional.isPresent())
        {
            throw new RuntimeException("No product found by the id: " + id);
        }

        return productOptional.get();
    }

    @Override
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
}
