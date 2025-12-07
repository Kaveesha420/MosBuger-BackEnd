package edu.icet.shop.model.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
    private String orderId;
    private String orderDetailsId;
    private String customerId;
    private String productId;
    private int qty;
    private LocalDate localDate;
    private Double totalPrice;
}
