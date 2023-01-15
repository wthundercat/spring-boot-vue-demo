package com.wai.demo.repo;

import com.wai.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Procedure(procedureName = "FIND_CUSTOMERS_BY_ADDRESS")
    List<Customer> getCustomersByAddress(@Param("address") String address);
}
