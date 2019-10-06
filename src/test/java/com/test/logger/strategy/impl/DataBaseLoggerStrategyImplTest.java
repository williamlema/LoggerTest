package com.test.logger.strategy.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.test.logger.constant.LogLevel;
import com.test.logger.model.Log;
import com.test.logger.repository.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataBaseLoggerStrategyImplTest {

  @InjectMocks
  private DataBaseLoggerStrategyImpl strategy;

  @Mock
  private LogRepository logRepository;

  @Test
  public void  givenLogLevelAndMessage_whenLogMessage_thenDoLog() {

    when(logRepository.save(any(Log.class))).thenReturn(new Log());

    strategy.logMessage(LogLevel.ERROR, "Message");

    verify(logRepository).save(any(Log.class));
    verifyNoMoreInteractions(logRepository);

  }
}
