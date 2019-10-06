package com.test.logger.constant;

/**
 * Enum to control supported log information levels
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public enum LogLevel {

  MESSAGE ("message"),
  WARNING ("warning"),
  ERROR ("error");

  String description;

  LogLevel(String description){
    this.description = description;
  }

  public String getDescription(){
    return this.description;
  }

}
