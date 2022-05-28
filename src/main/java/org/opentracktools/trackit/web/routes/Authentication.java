package org.opentracktools.trackit.web.routes;

import org.opentracktools.trackit.domain.application.service.api.UserAuthenticationService;
import org.opentracktools.trackit.web.forms.auth.SigninForm;
import org.opentracktools.trackit.web.forms.auth.SignupForm;
import org.opentracktools.trackit.web.response.auth.AuthServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

/**
 * @author Arpan Mukhopadhyay
 */
@Controller
public class Authentication extends Base {

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	/**
	 *
	 * @param form
	 * @return
	 */
	@GetMapping(path = { "/signin" })
	public String signin(@ModelAttribute("form") SigninForm form) {
		return SIGNIN_VIEW;
	}

	// TODO direct signup will be disabled when user creation via admin account is
	// done
	/**
	 *
	 * @param form
	 * @return
	 */
	@GetMapping(path = { "/signup" })
	public String signup(@ModelAttribute("form") SignupForm form) {
		return SIGNUP_VIEW;
	}

	/**
	 *
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(path = { "/signup" })
	public String signup(@ModelAttribute("form") @Valid final SignupForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return SIGNUP_VIEW;
		} else {
			AuthServiceResponse authServiceResponse = userAuthenticationService.registerNewUser(form);
			if (authServiceResponse.isSuccess()) {
				return SIGNUP_VIEW;
			} else {
				return SIGNUP_VIEW;
			}
		}
	}
}
