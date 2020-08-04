package com.wimmelsoft.rmidemo.server.service;

import com.wimmelsoft.rmidemo.common.CustomerDTO;
import com.wimmelsoft.rmidemo.common.CustomerService;
import com.wimmelsoft.rmidemo.mapper.CustomerMapper;
import com.wimmelsoft.rmidemo.server.dao.CustomerRepository;
import com.wimmelsoft.rmidemo.server.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getNumberOfCustomers() {

    }

    @Override
    public String getApplicationName() {
        return "Rmi Demo Application";
    }

    @Override
    public CustomerDTO getCustomer(long id) {
        Customer customer = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        CustomerMapper mapper = new CustomerMapper();
        CustomerDTO dto = mapper.mapToDTO(customer);
        System.out.println(dto);
        return dto;
    }

    public List<Customer> getCustomers() {
        return (List<Customer>)repository.findAll();
    }
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }
}
