package edu.icet.shop.Repositry;

import edu.icet.shop.model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositry extends JpaRepository<Customer,String> {
}
