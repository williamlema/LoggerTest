package com.test.logger.strategy.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.test.logger.constant.LogLevel;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleLoggerStrategyImplTest {

  private ConsoleLoggerStrategyImpl strategy;

  @Test
  public void givenLogLevelAndMessage_whenLogMessage_thenDoLog() {
    strategy = new ConsoleLoggerStrategyImpl();
    strategy.logMessage(LogLevel.ERROR,"Message");
    Logger logger = (Logger) ReflectionTestUtils.getField(strategy,"logger");

    assertThat(logger.getHandlers()[0]).isInstanceOf(ConsoleHandler.class);
  }
}
