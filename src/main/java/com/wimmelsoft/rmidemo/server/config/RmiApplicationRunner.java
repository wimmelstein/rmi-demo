package com.wimmelsoft.rmidemo.server.config;

import com.wimmelsoft.rmidemo.server.service.IsEvenService;
import com.wimmelsoft.rmidemo.server.service.IsEvenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

@Component
public class RmiApplicationRunner {

  private IsEvenServiceImpl isEvenService;

  public RmiApplicationRunner(IsEvenServiceImpl isEvenService) {
    this.isEvenService = isEvenService;
  }

  @Bean
  public RmiServiceExporter exporter() {
    RmiServiceExporter isEvenExporter = new RmiServiceExporter();
    isEvenExporter.setRegistryPort(1199);
    isEvenExporter.setServiceName("IsEvenService");
    isEvenExporter.setServiceInterface(IsEvenService.class);
    isEvenExporter.setService(isEvenService);
    return isEvenExporter;
  }

}
