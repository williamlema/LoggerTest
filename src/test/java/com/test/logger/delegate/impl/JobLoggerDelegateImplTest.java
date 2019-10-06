package com.test.logger.delegate.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.test.logger.constant.LogLevel;
import com.test.logger.constant.LogResource;
import com.test.logger.factory.api.ILoggerStrategyFactory;
import com.test.logger.strategy.api.ILoggerStrategy;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobLoggerDelegateImplTest {

  @InjectMocks
  private JobLoggerDelegateImpl delegate;

  @Mock
  private ILoggerStrategyFactory factory;

  @Test( expected = RuntimeException.class)
  public void givenNullMessageToSave_whenLogMessage_thenThrowsRuntimeException() {

    delegate.logMessage(LogResource.CONSOLE, LogLevel.ERROR, null);
  }

  @Test
  public void givenMessageToLog_whenLogMessage_thenDoLogMessage() {

    String message = "Message";
    ILoggerStrategy logger = mock(ILoggerStrategy.class);


    when(factory.getLoggerService(LogResource.CONSOLE)).thenReturn(logger);
    doNothing().when(logger).logMessage(LogLevel.ERROR, message);

    delegate.logMessage(LogResource.CONSOLE, LogLevel.ERROR, message);

    verify(factory).getLoggerService(LogResource.CONSOLE);
    verify(logger).logMessage(LogLevel.ERROR, message);
    verifyNoMoreInteractions(factory, logger);

  }

  @Test
  public void givenMessageToLogInMultipleResource_whenLogMessage_thenDoLogMessage() {

    String message = "Message";
    ILoggerStrategy logger = mock(ILoggerStrategy.class);
    List<LogResource> resourceList = new ArrayList<>();
    resourceList.add(LogResource.CONSOLE);
    resourceList.add(LogResource.FILE);


    when(factory.getLoggerService(any(LogResource.class))).thenReturn(logger);
    doNothing().when(logger).logMessage(LogLevel.ERROR, message);

    delegate.logMessage(resourceList, LogLevel.ERROR, message);

    verify(factory, times(2)).getLoggerService(any(LogResource.class));
    verify(logger, times(2)).logMessage(LogLevel.ERROR, message);
    verifyNoMoreInteractions(factory, logger);

  }
}
