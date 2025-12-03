package edu.icet.shop.Controller;

import edu.icet.shop.Service.ProductService;
import edu.icet.shop.model.Dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;

    @PostMapping("addProduct")
    public String addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping("searchProduct/{id}")
    public ProductDto searchProduct(@PathVariable String id){
        return productService.searchProduct(id);
    }

    @GetMapping("getAllProduct")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }

    @PostMapping("updateProduct/{id}")
    public String updateProduct(@RequestBody ProductDto productDto,@PathVariable("id") String id){
        return productService.updateProduct(productDto,id);
    }
}
