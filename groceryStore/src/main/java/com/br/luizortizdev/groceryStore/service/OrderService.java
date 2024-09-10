package com.br.luizortizdev.groceryStore.service;

import com.br.luizortizdev.groceryStore.client.ClientOrder;
import com.br.luizortizdev.groceryStore.client.response.ProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ClientOrder clientOrder;
    public List<ProductsResponse> getProductById(String id) {
        return clientOrder.getProductsById(id);
    }

    public List<ProductsResponse> getProducts() {
        return clientOrder.listProducts();
    }
}
