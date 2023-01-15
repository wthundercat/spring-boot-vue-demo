package com.wai.demo.service;

import com.wai.demo.entity.Customer;
import com.wai.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public List<Customer> getCustomerByAddress(String address){
        return customerRepo.getCustomersByAddress(address);
    }
}
