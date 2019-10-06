package com.test.logger.delegate.impl;

import com.test.logger.constant.LogLevel;
import com.test.logger.constant.LogResource;
import com.test.logger.delegate.api.IJobLoggerDelegate;
import com.test.logger.factory.api.ILoggerStrategyFactory;
import com.test.logger.strategy.api.ILoggerStrategy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Implementation class for {@IJobLoggerDelegate}
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Component
public class JobLoggerDelegateImpl implements IJobLoggerDelegate {

  private final ILoggerStrategyFactory loggerStrategyFactory ;

  private ILoggerStrategy loggerService;

  @Autowired
  public JobLoggerDelegateImpl(
      ILoggerStrategyFactory loggerStrategyFactory) {
    this.loggerStrategyFactory = loggerStrategyFactory;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void logMessage(LogResource logResource, LogLevel logLevel, String message) {

    if(StringUtils.isEmpty(message)){
      throw new RuntimeException("Message must be specified");
    }

    this.loggerService = this.loggerStrategyFactory.getLoggerService(logResource);

    this.loggerService.logMessage(logLevel, message);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void logMessage(List<LogResource> logResourceList, LogLevel logLevel, String message) {

    logResourceList.stream().forEach(logResource -> logMessage(logResource, logLevel, message));

  }
}
