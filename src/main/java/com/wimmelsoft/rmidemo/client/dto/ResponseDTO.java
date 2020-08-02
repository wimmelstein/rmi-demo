package com.wimmelsoft.rmidemo.client.dto;

public class ResponseDTO {

  private String message;
  private Object value;

  public ResponseDTO(String message, Object value) {
    this.message = message;
    this.value = value;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ResponseDTO{");
    sb.append("message='").append(message).append('\'');
    sb.append(", value=").append(value);
    sb.append('}');
    return sb.toString();
  }
}
