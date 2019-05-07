package app.api.v1.controllers;

import app.models.Product;
import app.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    List<Product> getAll()
    {
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Product findOne(@PathVariable Long id)
    {
        return productService.findById(id);
    }

    @CrossOrigin
    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    List<Product> saveProduct(@RequestBody @Valid Product product)
    {
        productService.save(product);

        return productService.findAll();
    }
}
