package app.services;

import app.models.Purchase_Product;
import app.repositorys.Purchase_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Purchase_ProductServiceImpl implements Purchase_ProductService
{
    @Autowired
    Purchase_ProductRepository purchase_productRepository;

    @Override
    public Set<Purchase_Product> findAll()
    {
        HashSet<Purchase_Product> set = new HashSet<>();

        purchase_productRepository.findAll().iterator().forEachRemaining(set::add);

        return set;
    }

    @Override
    public Purchase_Product findById(Long id)
    {
        return purchase_productRepository.findById(id).orElse(null);
    }

    @Override
    public Purchase_Product save(Purchase_Product purchase_product)
    {
        return purchase_productRepository.save(purchase_product);
    }

    @Override
    public void delete(Purchase_Product purchase_product)
    {
        purchase_productRepository.delete(purchase_product);
    }

    @Override
    public void deleteById(Long id)
    {
        purchase_productRepository.deleteById(id);
    }
}
