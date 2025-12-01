package edu.icet.shop.model.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
    private String id;
    private String name;
    private String age;
    private String address;
    private String nic;
}
