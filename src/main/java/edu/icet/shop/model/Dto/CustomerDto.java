package edu.icet.shop.model.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto{
    private String id;
    private String name;
    private String age;
    private String address;
    private String nic;
}
