package com.test.logger.strategy.api;

import com.test.logger.constant.LogLevel;

/**
 * Define set of functions to save log information
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public interface ILoggerStrategy {

  /**
   * Log string message in specific {@link LogLevel}
   *
   * @param logLevel
   * @param message
   */
  void logMessage(LogLevel logLevel, String message);
}
