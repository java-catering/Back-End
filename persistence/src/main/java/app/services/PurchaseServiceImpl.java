package app.services;

import app.models.Purchase;
import app.models.Status;
import app.repositorys.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PurchaseServiceImpl implements PurchaseService
{
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Set<Purchase> findAll()
    {
        HashSet<Purchase> set = new HashSet<>();

        purchaseRepository.findAll().forEach(set::add);

        return set;
    }

    @Override
    public Purchase findById(Long id)
    {
        return purchaseRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Purchase> findAllByUserEmail(String email)
    {
        return null;
    }

    @Override
    public Purchase save(Purchase purchase)
    {
        purchase.setStatus(Status.PREPPING);

        Double sum = StreamSupport.stream(purchase.getPurchase_products()
                .spliterator(), false)
                .map(pp -> pp.getProduct().getUnit_price() * pp.getQuantity())
                .reduce(Double::sum)
                .orElse(0.0D);

        purchase.setTotal(sum);

        return purchaseRepository.save(purchase);
    }

    @Override
    public void delete(Purchase purchase)
    {
        purchaseRepository.delete(purchase);
    }

    @Override
    public void deleteById(Long id)
    {
        purchaseRepository.deleteById(id);
    }
}
