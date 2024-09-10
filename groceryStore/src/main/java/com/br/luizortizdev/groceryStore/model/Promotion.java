package com.br.luizortizdev.groceryStore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promotion")
@Data
public class Promotion {

    @Id
    private String id;
    private String type;
    private int requiredQty;
    private int freeQty;
    private int amount;
}
