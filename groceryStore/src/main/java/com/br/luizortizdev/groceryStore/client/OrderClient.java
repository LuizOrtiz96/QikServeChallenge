package com.br.luizortizdev.groceryStore.client;

import com.br.luizortizdev.groceryStore.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "OrderClient", url = "http://localhost:8081"
)
public interface OrderClient {
    @GetMapping(value = "/products")
    List<Product> listProducts();

    @GetMapping(value = "/products/{id}")
    Product getProductById(@PathVariable("id") String id);
}
