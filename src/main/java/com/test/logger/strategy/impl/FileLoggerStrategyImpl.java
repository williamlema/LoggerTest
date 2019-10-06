package com.test.logger.strategy.impl;

import static com.test.logger.util.Utils.formatMessage;

import com.test.logger.constant.LogLevel;
import com.test.logger.strategy.api.ILoggerStrategy;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;

/**
 * Implementation class for {@link ILoggerStrategy} save log information at file
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Component
@Qualifier("FileLoggerStrategyImpl")
public class FileLoggerStrategyImpl implements ILoggerStrategy {

  private static Logger logger;

  @Value("${application.logger.filename}")
  private String logFile;

  public FileLoggerStrategyImpl() {
    logger = Logger.getLogger(FileLoggerStrategyImpl.class.getName());
  }

  private void verifyLoggerConfiguration () {
    try {

      File file = new File(logFile);
      FileUtils.touch(file);
      logger.addHandler(new FileHandler(logFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void logMessage(LogLevel logLevel, String message) {
    verifyLoggerConfiguration();
    logger.log(Level.INFO, formatMessage(logLevel,message));
  }
}
