package org.opentracktools.trackit.web.routes;

import org.opentracktools.trackit.domain.application.service.impl.ApplicationUserDetails;
import org.opentracktools.trackit.web.views.I_ViewConstant;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Arpan Mukhopadhyay
 */
public abstract class BaseRoute implements I_ViewConstant {

	/**
	 * 
	 * @param username
	 * @return
	 */
	protected boolean isCurrentUserMe(@NotBlank String username) {
		Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return null != principalObject && ((ApplicationUserDetails) principalObject).getUsername().equals(username);
	}
}
