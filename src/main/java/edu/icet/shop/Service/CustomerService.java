package edu.icet.shop.Service;

import edu.icet.shop.Repositry.CustomerRepositry;
import edu.icet.shop.model.Dto.CustomerDto;
import edu.icet.shop.model.Entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    final CustomerRepositry customerRepositry;
    public String addCustomer(CustomerDto customerDto) {
        List<Customer> customers = customerRepositry.findAll();
        String genarateId = "C001";
        int genIntId=1;
        for (Customer customer:customers){
            if (customer.getId().equals(genarateId)){
                genIntId++;
                genarateId=String.format("C%03d",genIntId);
            }else{break;}
        }
        Customer customer =new Customer(
                genarateId,
                customerDto.getName(),
                customerDto.getAge(),
                customerDto.getAddress(),
                customerDto.getNic()
        );
        customerRepositry.save(customer);
        return "Customer added Successfully";
    }

    public CustomerDto searchCustomer(String id) {
        Customer customer = customerRepositry.findById(id).orElse(null);
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAge(),
                customer.getAddress(),
                customer.getNic()
        );
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepositry.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer : customers){
            customerDtos.add(new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getAge(),
                    customer.getAddress(),
                    customer.getNic()
            ));
        }
        return customerDtos;
    }

    public void deleteCustomer(String id) {
        customerRepositry.deleteById(id);
    }

    public String updateCustomer(CustomerDto customerDto, String id) {
        List<Customer> customers = customerRepositry.findAll();
        for (Customer customer:customers){
            if (customer.getId().equals(id)){
                customerRepositry.save(new Customer(
                        id,
                        customerDto.getName(),
                        customerDto.getAge(),
                        customerDto.getAddress(),
                        customerDto.getNic()
                ));
                return "Customer Added Successfully";
            }
        }
        return "Customer Doesn't Exist...!";
    }
}
