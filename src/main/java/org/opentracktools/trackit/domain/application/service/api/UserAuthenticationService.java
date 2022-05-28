package org.opentracktools.trackit.domain.application.service.api;

import org.opentracktools.trackit.web.forms.auth.SignupForm;
import org.opentracktools.trackit.web.response.auth.AuthServiceResponse;

/**
 * @author Arpan Mukhopadhyay
 */
public interface UserAuthenticationService {

	/**
	 *
	 * @param form
	 * @return
	 */
	AuthServiceResponse registerNewUser(final SignupForm form);
}
