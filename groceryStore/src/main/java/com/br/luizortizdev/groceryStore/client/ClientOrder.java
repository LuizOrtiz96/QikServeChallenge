package com.br.luizortizdev.groceryStore.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "ClientOrder", url = "http://localhost:8081/products"
)
public interface ClientOrder {
    @GetMapping("/products")
    List<ProductsResponse> listProducts();

    @GetMapping(value = "/{id}")
    List<ProductsResponse> getProductsById(@PathVariable("id")String id);
}
