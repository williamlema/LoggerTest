package com.test.logger.delegate.api;

import com.test.logger.constant.LogLevel;
import com.test.logger.constant.LogResource;
import java.util.List;

/**
 * Delegate to save log information, depend of need could save log in many resource {@link LogResource}
 * at the same time, also could save information in specific supported {@link LogLevel}
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public interface IJobLoggerDelegate {

  /**
   * Log string message at specific level and resource
   *
   * @param logResource
   * @param logLevel
   * @param message
   */
  void logMessage(LogResource logResource, LogLevel logLevel, String message);


  /**
   * Log string message at specific level in multiple resource
   *
   * @param logResourceList
   * @param logLevel
   * @param message
   */
  void logMessage(List<LogResource> logResourceList, LogLevel logLevel, String message);

}
