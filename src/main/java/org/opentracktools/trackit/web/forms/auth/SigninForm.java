package org.opentracktools.trackit.web.forms.auth;

import lombok.Getter;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
public class SigninForm {
  
  private String login;
  private String password;
  
  /**
   * @param login
   * @param password
   */
  public SigninForm(String login, String password) {
    this.login = login;
    this.password = password;
  }
}
