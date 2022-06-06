/**
 *
 */
package org.opentracktools.trackit.web.routes;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
