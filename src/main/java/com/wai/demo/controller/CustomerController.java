package com.wai.demo.controller;

import com.wai.demo.entity.Customer;
import com.wai.demo.modal.RequestPayload;
import com.wai.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Value("${spring.datasource.username}")
    String username;

    @GetMapping
    List<Customer> getCustomers(  ){
        //retrieve records from teh database
        System.out.println("getCustomers " + username);
       return customerService.getAllCustomers();
    }

    @PostMapping
    void addCustomers(@RequestBody RequestPayload payload){
        //retrieve records from teh database
        System.out.println("getCustomers " + payload);
        customerService.addCustomer(payload);
        ///return customerService.getAllCustomers();
    }


    @GetMapping(value = "/{address}")
    List<Customer> getCustomerByAddress(@PathVariable(value = "address") String address  ){
        //retrieve records from teh database
        System.out.println("getCustomerByAddress " + address);
        return customerService.getCustomerByAddress(address);
    }

    @PutMapping(value = "/{customerId}")
    void removeCustomerById(@PathVariable(value = "customerId") long customerId){
        customerService.removeCustomerById(customerId);
    }

}
