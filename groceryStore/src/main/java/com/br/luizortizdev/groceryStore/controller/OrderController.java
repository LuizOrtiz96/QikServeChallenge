package com.br.luizortizdev.groceryStore.controller;

import com.br.luizortizdev.groceryStore.client.ClientOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/api")
public class OrderController {

    private final ClientOrder clientOrder;

    public OrderController(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    @GetMapping("/products")
    public ResponseEntity<String> helloWorld() {

        return ResponseEntity.ok(clientOrder.helloWorld());
    }
}
