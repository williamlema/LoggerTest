package com.test.logger.strategy.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.test.logger.constant.LogLevel;
import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class FileLoggerStrategyImplTest {

  private FileLoggerStrategyImpl strategy;

  @Test
  public void givenLogLevelAndMessage_whenLogMessage_thenDoLog() {
    String filename = "./logFileTest.txt";
    strategy = new FileLoggerStrategyImpl();
    ReflectionTestUtils.setField(strategy,"logFile",filename);

    strategy.logMessage(LogLevel.ERROR,"Message");
    Logger logger = (Logger)ReflectionTestUtils.getField(strategy,"logger");

    FileUtils.deleteQuietly(new File(filename));
    assertThat(logger.getHandlers()[0]).isInstanceOf(FileHandler.class);
  }
}
