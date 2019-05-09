package app.services;

import app.models.Purchase;

import java.util.Set;

public interface PurchaseService
{
    Set<Purchase> findAll();

    Purchase findById(Long id);

    Set<Purchase> findAllByUserEmail(String email);

    Purchase save(Purchase purchase);

    void delete(Purchase purchase);

    void deleteById(Long id);

}
