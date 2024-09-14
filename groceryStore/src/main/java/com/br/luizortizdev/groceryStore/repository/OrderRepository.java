package com.br.luizortizdev.groceryStore.repository;

import com.br.luizortizdev.groceryStore.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderItem, Long> {
}
