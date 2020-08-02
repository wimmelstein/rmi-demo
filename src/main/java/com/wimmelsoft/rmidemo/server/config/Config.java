package com.wimmelsoft.rmidemo.server.config;

import com.wimmelsoft.rmidemo.server.service.IsEvenService;
import com.wimmelsoft.rmidemo.server.service.IsEvenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.util.logging.Logger;

@Configuration
public class Config {

  private IsEvenServiceImpl isEvenService;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public Config(IsEvenServiceImpl isEvenService) {
    this.isEvenService = isEvenService;
  }

  @Bean("rmiServer")
  public RmiServiceExporter exporter() {
    RmiServiceExporter isEvenExporter = new RmiServiceExporter();
    isEvenExporter.setRegistryPort(1199);
    isEvenExporter.setServiceName("IsEvenService");
    isEvenExporter.setServiceInterface(IsEvenService.class);
    isEvenExporter.setService(isEvenService);logger.info("Started RMI Server");
    return isEvenExporter;
  }

  @Bean
  @DependsOn("rmiServer")
  public RmiProxyFactoryBean proxyFactoryBean() {
    String remoteHost = System.getProperty("RMI_HOST");
    String rmiHost = String.format("rmi://%s:1199/IsEvenService", remoteHost);
    logger.info("RMI Host name is " + rmiHost);
    RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
    proxy.setServiceInterface(IsEvenService.class);
    proxy.setServiceUrl(rmiHost);
    proxy.afterPropertiesSet();
    return proxy;
  }

}
