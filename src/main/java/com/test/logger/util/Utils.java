package com.test.logger.util;

import com.test.logger.constant.LogLevel;
import java.text.DateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public class Utils {

  /**
   * Format message concatenating Log level, current date and message
   *
   * @param logLevel
   * @param message
   * @return
   */
  public static String formatMessage (LogLevel logLevel, String message ){
    return logLevel.getDescription()
        .concat(StringUtils.SPACE)
        .concat(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
        .concat(StringUtils.SPACE)
        .concat(message);
  }

}
