package com.br.luizortizdev.groceryStore.controller;

import com.br.luizortizdev.groceryStore.client.ClientOrder;
import com.br.luizortizdev.groceryStore.client.ProductsResponse;
import com.br.luizortizdev.groceryStore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public List<ProductsResponse> listProducts() {
        return orderService.getProducts();
    }

    @GetMapping(name = "/{id}")
    public List<ProductsResponse> getProductById(@PathVariable String id){
        return orderService.getProductById(id);
    }
}
