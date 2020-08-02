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
  private RmiProxyFactoryBean proxyFactoryBean;

  public IsEvenController(RmiProxyFactoryBean proxyFactoryBean) {
    this.proxyFactoryBean = proxyFactoryBean;
  }

  @RequestMapping(value = "{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> isEven(@PathVariable int number) {
    int status = 200;
    ResponseDTO response;
    try {
     response = new ResponseDTO(String.format("Is %d even", number), getEven(number));
    } catch (IllegalArgumentException iae) {
      response = new ResponseDTO("error", iae.getMessage());
      status = 400;
    }
    return ResponseEntity.status(status).body(response);
  }

  private boolean getEven(int number) {
    if ("localhost".equals(System.getProperty("RMI_HOST"))) {
      throw new IllegalArgumentException("You're not supposed to call yourself");
    }
    IsEvenService service = (IsEvenService) proxyFactoryBean.getObject();
    return Objects.requireNonNull(service).isEven(number);
  }
}

