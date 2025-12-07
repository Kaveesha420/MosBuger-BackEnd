package edu.icet.shop.model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Order {
    @Id
    @Column(name = "order_Id")
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customerId;
    private LocalDate orderDate;
}
