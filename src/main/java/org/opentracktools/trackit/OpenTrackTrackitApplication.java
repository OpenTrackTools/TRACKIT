package org.opentracktools.trackit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Arpan Mukhopadhyay
 */
@SpringBootApplication
public class OpenTrackTrackitApplication {
  
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ConfigurableApplicationContext trackitApplicationContext = SpringApplication.run(OpenTrackTrackitApplication.class, args);
  }
}
