package edu.icet.shop.Service;

import edu.icet.shop.Repositry.ProductRepositry;
import edu.icet.shop.model.Dto.ProductDto;
import edu.icet.shop.model.Entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    final ProductRepositry productRepositry;

    public String addProduct(ProductDto productDto) {
        List<Product> products = productRepositry.findAll();
        String genarateId = "P001";
        int genIntId = 1;

        for (Product product:products){
            if (product.getId().equals(genarateId)){
                genIntId++;
                genarateId=String.format("P%03d",genIntId);
            }else{break;}
        }
        Product product = new Product(
                genarateId,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getQty(),
                productDto.getUnitPrice()
        );
        productRepositry.save(product);
        return "Product added Successfuly";
    }

    public ProductDto searchProduct(String id) {
        Product product = productRepositry.findById(id).orElse(null);
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQty(),
                product.getUnitPrice()
        );
    }

    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepositry.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product:products){
            productDtos.add(new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getQty(),
                    product.getUnitPrice()
            ));
        }
        return productDtos;
    }

    public String deleteProduct(String id) {
        productRepositry.deleteById(id);
        return "Product Deleted Successfully";
    }

    public String updateProduct(ProductDto productDto, String id) {
        List<Product> products = productRepositry.findAll();
        for (Product product:products){
            if (product.getId().equals(id)){
                productRepositry.save(new Product(
                        id,
                        productDto.getName(),
                        productDto.getDescription(),
                        productDto.getQty(),
                        productDto.getUnitPrice()
                ));
                return "Product Updated Successfully";
            }
        }
        return "Product Doesn't Exist";
    }
}
