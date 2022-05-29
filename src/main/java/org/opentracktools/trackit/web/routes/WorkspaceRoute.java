/**
 * 
 */
package org.opentracktools.trackit.web.routes;

import java.util.Collection;

import org.opentracktools.trackit.domain.application.service.impl.WorkspaceServiceImpl;
import org.opentracktools.trackit.domain.models.user.IUserNameObjectId;
import org.opentracktools.trackit.web.forms.workspace.WorkspaceForm;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;

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
	@SuppressWarnings("unchecked")
	@GetMapping(path = {"/workspaces/new"})
	public String createWorkspace(@ModelAttribute(name = "form") WorkspaceForm workspaceForm, Model model) {
		WorkspaceServiceResponse response = workspaceService.listUserObjectIds();
		Collection<IUserNameObjectId> usernameObjectIds = null;
		if (response.isSuccess()) {
			usernameObjectIds = (Collection<IUserNameObjectId>) response.getResult();
		}
		log.info("{}", usernameObjectIds);
		model.addAttribute("userList", usernameObjectIds);
		return WORKSPACE_CREATE_VIEW;
	}
}
