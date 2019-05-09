package app.config;

import app.models.*;
import app.services.ProductService;
import app.services.PurchaseService;
import app.services.Purchase_ProductService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap implements CommandLineRunner
{

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    Purchase_ProductService purchase_productService;

    // we will add all our mock users and purchases here.
    @Override
    public void run(String... args) throws Exception
    {
        Product cheeseburger = new Product();
        cheeseburger.setDescription("A Cheese burger");
        cheeseburger.setIs_available(true);
        cheeseburger.setTitle("Cheese burger");
        cheeseburger.setUnit_price(119.99D);

        productService.save(cheeseburger);

        User eric = new User().builder()
                .first_name("Eric")
                .last_name("Gomez")
                .email("eric@example.com")
                .password("123")
                .build();

        userService.saveAdmin(eric);

        User stan = new User().builder()
                .first_name("Stan")
                .last_name("Smith")
                .email("stan@cia.com")
                .password("hello")
                .build();

        userService.save(stan);

        Purchase stans_purchase = new Purchase();
        stans_purchase.setUser(stan);

        purchaseService.save(stans_purchase);

        Purchase_Product productOne = new Purchase_Product();
        productOne.setProduct(cheeseburger);
        productOne.setQuantity(1);
        productOne.setPurchase(stans_purchase);

        purchase_productService.save(productOne);

    }
}
