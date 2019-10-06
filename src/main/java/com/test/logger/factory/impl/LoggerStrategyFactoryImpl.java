package com.test.logger.factory.impl;

import com.test.logger.constant.LogResource;
import com.test.logger.factory.api.ILoggerStrategyFactory;
import com.test.logger.strategy.api.ILoggerStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation class for {@link ILoggerStrategyFactory}
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Component
public class LoggerStrategyFactoryImpl implements ILoggerStrategyFactory {

  private final ILoggerStrategy consoleLoggerStrategy;

  private final ILoggerStrategy fileLoggerStrategy;

  private final ILoggerStrategy dataBaseLoggerStrategy;

  @Autowired
  public LoggerStrategyFactoryImpl(
      @Qualifier("ConsoleLoggerStrategyImpl")ILoggerStrategy consoleLoggerStrategy,
      @Qualifier("FileLoggerStrategyImpl")ILoggerStrategy fileLoggerStrategy,
      @Qualifier("DataBaseLoggerStrategyImpl")ILoggerStrategy dataBaseLoggerStrategy) {
    this.consoleLoggerStrategy = consoleLoggerStrategy;
    this.fileLoggerStrategy = fileLoggerStrategy;
    this.dataBaseLoggerStrategy = dataBaseLoggerStrategy;
  }

  @Override
  public ILoggerStrategy getLoggerService(LogResource logResource) {
    ILoggerStrategy strategy = null;
    switch (logResource){
      case CONSOLE:
        strategy = this.consoleLoggerStrategy;
        break;
      case FILE:
        strategy = this.fileLoggerStrategy;
        break;
      case DATA_BASE:
        strategy = this.dataBaseLoggerStrategy;
        break;
    }
    return strategy;
  }
}
