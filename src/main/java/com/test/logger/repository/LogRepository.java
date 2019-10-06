package com.test.logger.repository;

import com.test.logger.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle {@link Log} entity in database
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public interface LogRepository  extends JpaRepository<Log, Integer> {

}
