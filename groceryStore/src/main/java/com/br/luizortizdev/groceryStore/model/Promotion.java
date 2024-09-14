package com.br.luizortizdev.groceryStore.model;

import com.br.luizortizdev.groceryStore.util.PromotionType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promotions")
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Enumerated(EnumType.STRING)
    private PromotionType type; // Usando o enum PromotionType

    private int requiredQty;
    private int freeQty;
    private int amount;
    private int price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
