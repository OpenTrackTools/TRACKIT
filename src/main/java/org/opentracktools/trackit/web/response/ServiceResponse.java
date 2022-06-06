package org.opentracktools.trackit.web.response;

import lombok.Getter;
import lombok.Setter;
import org.opentracktools.trackit.core.ErrorCodes;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@Setter
public abstract class ServiceResponse implements ErrorCodes {
  
  private short errorCode;
  private String errorMessage;
  private Object result;
  
  public ServiceResponse() {
    this.errorCode = 1;
  }
  
  /**
   * @return
   */
  public boolean isSuccess() {
    return this.errorCode == 0;
  }
  
  /**
   *
   */
  public void success() {
    this.errorCode = 0;
  }
}
