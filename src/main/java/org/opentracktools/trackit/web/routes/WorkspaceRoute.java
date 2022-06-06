/**
 *
 */
package org.opentracktools.trackit.web.routes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.opentracktools.trackit.domain.application.service.impl.WorkspaceServiceImpl;
import org.opentracktools.trackit.web.forms.workspace.WorkspaceForm;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Controller
@Slf4j
public class WorkspaceRoute extends BaseRoute {
  
  @Autowired
  private WorkspaceServiceImpl workspaceService;
  
  /**
   *
   * @param workspaceForm
   * @param model
   * @return
   */
  @GetMapping(path = {"/workspaces/new"})
  public String create(@ModelAttribute(name = "form") WorkspaceForm workspaceForm, Model model) {
    return WORKSPACE_CREATE_VIEW;
  }
  
  /**
   *
   * @param form
   * @param result
   * @return
   */
  @PostMapping(path = {"/workspaces/new"})
  public String create(@ModelAttribute(name = "form") @Valid final WorkspaceForm form, BindingResult result) {
    log.info("{}", form);
    WorkspaceServiceResponse response = workspaceService.create(form);
    return "redirect:/workspaces";
  }
  
  /**
   *
   * @return
   */
  @GetMapping(path = {"/workspaces"})
  public String index() {
    return WORKSPACE_LIST_VIEW;
  }
}
