package com.wimmelsoft.rmidemo.server.service;

import org.springframework.stereotype.Service;

@Service
public class IsEvenServiceImpl implements IsEvenService {
  @Override
  public boolean isEven(int number) {
    return (number & 1) == 0;
  }
}
