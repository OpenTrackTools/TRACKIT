/**
 * 
 */
package org.opentracktools.trackit.web.routes;

import lombok.extern.slf4j.Slf4j;
import org.opentracktools.trackit.domain.application.service.impl.WorkspaceServiceImpl;
import org.opentracktools.trackit.web.forms.workspace.WorkspaceForm;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	public String createWorkspace(@ModelAttribute(name = "form") WorkspaceForm workspaceForm, Model model) {
		WorkspaceServiceResponse response = workspaceService.listUserObjectIds();
		model.addAttribute("users", response.getResult());
		return WORKSPACE_CREATE_VIEW;
	}
}
