package com.wimmelsoft.rmidemo.common;

public interface CustomerService {
    void getNumberOfCustomers();
    String getApplicationName();
    CustomerDTO getCustomer(long id);
}
