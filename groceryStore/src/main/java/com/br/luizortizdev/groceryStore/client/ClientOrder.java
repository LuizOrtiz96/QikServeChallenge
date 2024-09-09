package com.br.luizortizdev.groceryStore.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "ClientOrder", url = "https://google.com"
)
public interface ClientOrder {


    @GetMapping
    String helloWorld();
}
