package com.wai.demo.service;

import com.wai.demo.entity.Customer;
import com.wai.demo.entity.Room;
import com.wai.demo.modal.RequestPayload;
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

    public void  addCustomer(RequestPayload payload){
        Customer customer = new Customer();
        customer.setFirstName(payload.getFirstName());
        customer.setLastName(payload.getLastName());
        customer.setAddress(payload.getAddress());
        customer.setAge(payload.getAge());
        Room room = new Room();
        room.setRoomNumber(payload.getRoomNumber());
        customer.addRoom(room);

        Customer customer1 = customerRepo.save(customer);

    }
}
