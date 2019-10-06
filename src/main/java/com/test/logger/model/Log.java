package com.test.logger.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "log")
public class Log {

  @Id
  private Long id;

  private String message;

  private String logLevel;

  public Log() {
  }

  public Log(Long id, String message, String logLevel) {
    this.id = id;
    this.message = message;
    this.logLevel = logLevel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }
}
