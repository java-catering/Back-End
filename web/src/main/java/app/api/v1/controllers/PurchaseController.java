package app.api.v1.controllers;

import app.models.Purchase;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PurchaseController
{

    @CrossOrigin
    @PostMapping("/purchase")
    public void submitPurchase(@RequestBody @Valid Purchase purchase)
    {
    }

}


//{
//    user_id: 123
//    purchase: {
//        total:
//        status:
//        user: 123
//        purchase_products: [
//            {purchase: 1, product: 1, quantity: 23}
//        ]
//    }
//
//
//}