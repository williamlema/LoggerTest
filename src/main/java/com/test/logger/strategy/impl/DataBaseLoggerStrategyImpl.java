package com.test.logger.strategy.impl;

import static com.test.logger.util.Utils.formatMessage;

import com.test.logger.constant.LogLevel;
import com.test.logger.model.Log;
import com.test.logger.repository.LogRepository;
import com.test.logger.strategy.api.ILoggerStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation class for {@link ILoggerStrategy} save log information at database
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Component
@Qualifier("DataBaseLoggerStrategyImpl")
public class DataBaseLoggerStrategyImpl implements ILoggerStrategy {

  private final LogRepository logRepository;

  @Autowired
  public DataBaseLoggerStrategyImpl(LogRepository logRepository) {

    this.logRepository = logRepository;
  }

  @Override
  public void logMessage(LogLevel logLevel, String message) {
    Log log = new Log(System.currentTimeMillis(), formatMessage(logLevel,message), logLevel.getDescription());
    this.logRepository.save(log);
  }
}
