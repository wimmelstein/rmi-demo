package com.wimmelsoft.rmidemo.server.dao;

import com.wimmelsoft.rmidemo.server.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(long id);
}
