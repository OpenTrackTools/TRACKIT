package org.opentracktools.trackit.web.routes;

import jakarta.validation.constraints.NotBlank;
import org.opentracktools.trackit.domain.application.service.impl.ApplicationUserDetails;
import org.opentracktools.trackit.web.views.I_ViewConstant;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Arpan Mukhopadhyay
 */
public abstract class BaseRoute implements I_ViewConstant {
  
  /**
   * @param username
   * @return
   */
  protected boolean isCurrentUserMe(@NotBlank String username) {
    Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principalObject instanceof ApplicationUserDetails userDetails) {
      final String sessionUsername = userDetails.getUsername();
      return sessionUsername.equals(username);
    }
    return false;
  }
}
