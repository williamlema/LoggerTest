package com.test.logger.factory.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.test.logger.constant.LogResource;
import com.test.logger.strategy.api.ILoggerStrategy;
import com.test.logger.strategy.impl.ConsoleLoggerStrategyImpl;
import com.test.logger.strategy.impl.DataBaseLoggerStrategyImpl;
import com.test.logger.strategy.impl.FileLoggerStrategyImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LoggerStrategyFactoryImplTest {

  private LoggerStrategyFactoryImpl factory;

  @Mock
  private ConsoleLoggerStrategyImpl consoleLoggerStrategy;

  @Mock
  private FileLoggerStrategyImpl fileLoggerStrategy;

  @Mock
  private DataBaseLoggerStrategyImpl dataBaseLoggerStrategy;

  @Before
  public void before () {
    factory = new LoggerStrategyFactoryImpl(consoleLoggerStrategy, fileLoggerStrategy, dataBaseLoggerStrategy);
  }

  @Test
  public void givenConsoleLogResource_whenGetLoggerService_thenReturnConsoleLoggerStrategyImpl() {

    ILoggerStrategy response = factory.getLoggerService(LogResource.CONSOLE);

    assertThat(response).isInstanceOf(ConsoleLoggerStrategyImpl.class);

  }

  @Test
  public void givenFileLogResource_whenGetLoggerService_thenReturnFileLoggerStrategyImpl() {

    ILoggerStrategy response = factory.getLoggerService(LogResource.FILE);

    assertThat(response).isInstanceOf(FileLoggerStrategyImpl.class);

  }

  @Test
  public void givenDataBaseLogResource_whenGetLoggerService_thenReturnDataBaseLoggerStrategyImpl() {

    ILoggerStrategy response = factory.getLoggerService(LogResource.DATA_BASE);

    assertThat(response).isInstanceOf(DataBaseLoggerStrategyImpl.class);

  }
}
