package com.br.luizortizdev.groceryStore.controller;

import com.br.luizortizdev.groceryStore.model.Product;
import com.br.luizortizdev.groceryStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = orderService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Product product = orderService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestParam String productId, @RequestParam int quantity) {
        orderService.addItemToOrder(productId, quantity);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> calculateTotal() {
        int total = orderService.calculateTotal();
        return ResponseEntity.ok(total);
    }


}
