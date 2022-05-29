/**
 * 
 */
package org.opentracktools.trackit.domain.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.opentracktools.trackit.infra.repository.UserRepository;
import org.opentracktools.trackit.web.forms.commons.UserDropDownEntry;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Service
@Slf4j
public class WorkspaceServiceImpl {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @return
	 */
	public WorkspaceServiceResponse listUserObjectIds() {
		WorkspaceServiceResponse response = new WorkspaceServiceResponse();
		List<UserDropDownEntry> userDropDown = new ArrayList<>();
		userRepository.getUsernameObjectIds().forEach(e -> {
			userDropDown.add(new UserDropDownEntry(e.getObjectId(), e.getUsername()));
		});
		response.setResult(userDropDown);
		response.setErrorCode((short) 0);
		return response;
	}
}
