package com.wimmelsoft.rmidemo.server.config;

import com.wimmelsoft.rmidemo.common.CustomerService;
import com.wimmelsoft.rmidemo.server.dao.CustomerRepository;
import com.wimmelsoft.rmidemo.server.model.Customer;
import com.wimmelsoft.rmidemo.server.service.CustomerServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RmiServerApplicationRunner implements ApplicationRunner {

    private CustomerRepository repository;
    private CustomerServiceImpl customerService;

    public RmiServerApplicationRunner(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    private final Logger log = Logger.getLogger(this.getClass().getName());



    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("John", "Smith", "123-456-7890");
        customerService.saveCustomer(customer1);
        customerService.getCustomers().forEach(System.out::println);

    }

    @Bean
    public RmiServiceExporter customerServiceExporter() {
        RmiServiceExporter customerServiceExporter = new RmiServiceExporter();
        customerServiceExporter.setRegistryPort(1199);
        customerServiceExporter.setServiceName("customerService");
        customerServiceExporter.setServiceInterface(CustomerService.class);
        customerServiceExporter.setService(customerService);
        log.info("Started RMI Server");
        return customerServiceExporter;
    }
}
