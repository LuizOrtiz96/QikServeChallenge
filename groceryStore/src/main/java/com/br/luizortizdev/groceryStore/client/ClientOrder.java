package com.br.luizortizdev.groceryStore.client;

import com.br.luizortizdev.groceryStore.client.response.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "ClientOrder", url = "http://localhost:8081"
)
public interface ClientOrder {
    @GetMapping(value = "/products")
    List<ProductsResponse> listProducts();

    @GetMapping(value = "/products/{id}")
    List<ProductsResponse> getProductsById(@PathVariable("id") String id);
}
