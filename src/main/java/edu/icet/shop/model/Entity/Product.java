package edu.icet.shop.model.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
    private String id;
    private String name;
    private String description;
    private int qty;
    private Double unitPrice;
}
