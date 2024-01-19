package com.example.demoHexa.src.adapter.in.web;

import com.example.demoHexa.src.application.domain.entity.Honey;
import com.example.demoHexa.src.application.domain.service.HoneyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Presentation Layer
*/

@RestController
@RequestMapping("/")
public class HoneyController {
    @Autowired
    private HoneyDomainService productService;

    @GetMapping("api/welcome")
    public String welcome() {
        return "Welcome to the world of Honeys!";
    }

    @GetMapping("api/products")
    public ResponseEntity<?> getAllProducts() {
        List<Honey> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No products available.");
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("api/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Honey product = productService.getProductById(id).orElse(null);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with id: " + id);
        }
    }

    @PostMapping("api/products/buy/{id}")
    public String buyProduct(@PathVariable Long id) {
        Honey product = productService.getProductById(id).orElse(null);

        if (product != null) {
            if (productService.buyProduct(id))
                return "Success!";
        }
        return "Try again!";
    }

    @PostMapping("api/products/add")
    public String addProduct(@RequestBody Honey product) {
        if (productService.addProduct(product))
            return "Success!";
        return "Try again!";
    }

    @PostMapping("api/products/increase/{id}/{nr}")
    public String increaseProduct(@PathVariable Long id, @PathVariable int nr) {
        if (productService.increaseProduct(id, nr))
            return "Success!";
        return "Try again!";
    }

    @PostMapping("api/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Honey product = productService.getProductById(id).orElse(null);

        if (product != null) {
            if (productService.deleteProduct(id))
                return "Success!";
        }
        return "Try again!";
    }

    @RequestMapping("/**")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return "No endpoint found.";
    }

}
