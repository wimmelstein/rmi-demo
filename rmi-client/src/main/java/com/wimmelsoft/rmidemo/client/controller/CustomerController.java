package com.wimmelsoft.rmidemo.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wimmelsoft.rmidemo.common.CustomerDTO;
import com.wimmelsoft.rmidemo.common.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "customers")
public class CustomerController {

    private RmiProxyFactoryBean proxyFactoryBean;

    public CustomerController(RmiProxyFactoryBean proxyFactoryBean) {
        this.proxyFactoryBean = proxyFactoryBean;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomer(@PathVariable long id) throws JsonProcessingException {

        CustomerService service = (CustomerService) proxyFactoryBean.getObject();
        CustomerDTO dto = service.getCustomer(id);
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(dto));

        return ResponseEntity.ok(mapper.writeValueAsString(dto));

    }
}

