package com.test.logger.controller;

import com.test.logger.constant.LogLevel;
import com.test.logger.constant.LogResource;
import com.test.logger.constant.Resource;
import com.test.logger.delegate.api.IJobLoggerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(Resource.LOGGER)
public class JobLoggerController {

  private final IJobLoggerDelegate jobLoggerDelegate;

  @Autowired
  public JobLoggerController(IJobLoggerDelegate jobLoggerDelegate) {
    this.jobLoggerDelegate = jobLoggerDelegate;
  }

  @GetMapping
  public ResponseEntity logMessage (){

    jobLoggerDelegate.logMessage(LogResource.FILE, LogLevel.ERROR, "message to log");

    return ResponseEntity
        .status(HttpStatus.OK).body("");
  }

}
