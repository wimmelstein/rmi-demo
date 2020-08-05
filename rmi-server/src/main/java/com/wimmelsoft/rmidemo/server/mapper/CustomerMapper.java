package com.wimmelsoft.rmidemo.server.mapper;

import com.wimmelsoft.rmidemo.common.CustomerDTO;
import com.wimmelsoft.rmidemo.server.model.Customer;

public class CustomerMapper {


    public CustomerMapper() {
    }

    public CustomerDTO mapToDTO(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setSocialSecurityCode(customer.getSocialSecurityCode());
        return dto;
    }
}
