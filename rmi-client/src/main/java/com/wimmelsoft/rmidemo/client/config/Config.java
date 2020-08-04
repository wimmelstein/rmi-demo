package com.wimmelsoft.rmidemo.client.config;

import com.wimmelsoft.rmidemo.common.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Config {

    public final Logger log = Logger.getLogger(this.getClass().getName());
    @Bean
    public RmiProxyFactoryBean proxyFactoryBean() {
        System.setProperty("RMI_HOST", "localhost");
        String remoteHost = System.getProperty("RMI_HOST");
        String rmiHost = String.format("rmi://%s:1199/customerService", remoteHost);
        log.info("RMI Host name is " + rmiHost);
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceInterface(CustomerService.class);
        proxy.setServiceUrl(rmiHost);
        proxy.afterPropertiesSet();
        return proxy;
    }
}
