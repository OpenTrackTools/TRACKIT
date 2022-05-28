package org.opentracktools.trackit.web.forms;

import lombok.Getter;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
public class SignupForm {
  
  private final String username;
  private final String password;
  private final String email;
  
  /**
   *
   * @param username
   * @param password
   * @param email
   */
  public SignupForm(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
