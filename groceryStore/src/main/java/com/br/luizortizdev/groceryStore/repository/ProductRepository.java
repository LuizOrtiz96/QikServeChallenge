package com.br.luizortizdev.groceryStore.repository;

import com.br.luizortizdev.groceryStore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {
    Optional<Product> findById(String id);
}
