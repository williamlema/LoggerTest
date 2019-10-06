package com.test.logger.strategy.impl;

import static com.test.logger.util.Utils.formatMessage;

import com.test.logger.constant.LogLevel;
import com.test.logger.strategy.api.ILoggerStrategy;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation class for {@link ILoggerStrategy} save log information at console
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Component
@Qualifier("ConsoleLoggerStrategyImpl")
public class ConsoleLoggerStrategyImpl implements ILoggerStrategy {

  private static Logger logger;

  public ConsoleLoggerStrategyImpl () {
    logger = Logger.getLogger(ConsoleLoggerStrategyImpl.class.getName());
    logger.addHandler(new ConsoleHandler());

  }

  @Override
  public void logMessage(LogLevel logLevel, String message) {
    logger.log(Level.INFO, formatMessage(logLevel,message));
  }
}
