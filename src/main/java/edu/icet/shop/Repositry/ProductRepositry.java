package edu.icet.shop.Repositry;

import edu.icet.shop.model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositry extends JpaRepository<Product,String> {
}
