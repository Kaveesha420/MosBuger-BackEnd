package edu.icet.shop.Controller;

import edu.icet.shop.Service.CustomerService;
import edu.icet.shop.model.Dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor

public class CustomerController {

    final CustomerService customerService;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

    @GetMapping("/searchCustomer/{id}")
    public CustomerDto searchCustomer(@PathVariable("id")String id){
        return customerService.searchCustomer(id);
    }

    @GetMapping("/getAllCustomer")
    public List<CustomerDto> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @PostMapping("/updateCustomer/{id}")
    public String updatCustomer(@RequestBody CustomerDto customerDto,@PathVariable("id") String id){
        return customerService.updateCustomer(customerDto,id);
    }

}
