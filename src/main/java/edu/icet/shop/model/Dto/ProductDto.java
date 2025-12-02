package edu.icet.shop.model.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private int qty;
    private Double unitPrice;
}
