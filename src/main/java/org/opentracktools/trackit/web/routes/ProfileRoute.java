/**
 * 
 */
package org.opentracktools.trackit.web.routes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.constraints.NotNull;

/**
 * @author arixion
 *
 */
@Controller
public class ProfileRoute extends BaseRoute {

	/**
	 * 
	 * @param profileId
	 * @return
	 */
	@GetMapping(path = {"/{profile}"})
	public String profile(@PathVariable(name = "profile", required = true) @NotNull String profile, Model model) {
		model.addAttribute("enableEditing", isCurrentUserMe(profile));
		model.addAttribute("profileDisplay", profile);
		return PROFILE_VIEW;
	}
}
