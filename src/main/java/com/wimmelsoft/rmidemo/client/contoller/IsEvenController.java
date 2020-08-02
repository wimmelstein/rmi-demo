package com.wimmelsoft.rmidemo.client.contoller;

import com.wimmelsoft.rmidemo.client.dto.ResponseDTO;
import com.wimmelsoft.rmidemo.server.service.IsEvenService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "iseven")
public class IsEvenController {

  private  final Logger logger = Logger.getLogger(this.getClass().getName());
  private String remoteHost = System.getProperty("RMI_HOST");

  @RequestMapping(value = "{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> isEven(@PathVariable int number) {
    ResponseDTO response;
    try {
     response = new ResponseDTO(String.format("Is %d even", number), getEven(number));
    } catch (IllegalArgumentException iae) {
      response = new ResponseDTO("error", iae.getMessage());
    }
    return ResponseEntity.ok(response);
  }

  private boolean getEven(int number) {
    if (Objects.isNull(remoteHost)) {
      throw new IllegalArgumentException("You're not supposed to call yourselfr");
    }
    String rmiHost = String.format("rmi://%s:1199/IsEvenService", remoteHost);
    logger.fine("RMI Host name is " + rmiHost);
    RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
    proxy.setServiceInterface(IsEvenService.class);
    proxy.setServiceUrl(rmiHost);
    proxy.afterPropertiesSet();
    IsEvenService service = (IsEvenService) proxy.getObject();
    return Objects.requireNonNull(service).isEven(number);
  }
}

