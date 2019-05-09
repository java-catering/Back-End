package app.api.v1.controllers;

import app.DAO_models.Purchase_Product_List;
import app.models.Purchase;
import app.services.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class PurchaseController
{
    @Autowired
    private PurchaseService purchaseService;

    @CrossOrigin
    @GetMapping("/purchase")
    public Set<Purchase> getPurchases()
    {
        return purchaseService.findAll();
    }

    @CrossOrigin
    @PostMapping({"/purchase", "/purchase/"})
    public void submitPurchase(@RequestBody Purchase purchase, @RequestBody Purchase_Product_List list)
    {
        StreamSupport.stream(list.getPurchase_product_list().spliterator(), false).map(pp -> {
            log.debug(pp.getProduct().getTitle());
            return null;
        });
    }
}