package com.test.logger.factory.api;

import com.test.logger.constant.LogResource;
import com.test.logger.strategy.api.ILoggerStrategy;

/**
 * Factory create to bring one point of access to different {@link ILoggerStrategy}
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public interface ILoggerStrategyFactory {

  /**
   * Return {@link ILoggerStrategy} implementation given {@link LogResource}
   *
   * @param logResource
   * @return
   */
  ILoggerStrategy getLoggerService(LogResource logResource);

}
