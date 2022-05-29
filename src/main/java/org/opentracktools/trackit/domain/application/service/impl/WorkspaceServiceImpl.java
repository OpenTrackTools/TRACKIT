/**
 * 
 */
package org.opentracktools.trackit.domain.application.service.impl;

import java.util.Collection;

import org.opentracktools.trackit.domain.models.user.IUserNameObjectId;
import org.opentracktools.trackit.infra.repository.UserRepository;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Service
public class WorkspaceServiceImpl {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @return
	 */
	public WorkspaceServiceResponse listUserObjectIds() {
		WorkspaceServiceResponse response = new WorkspaceServiceResponse();
		Collection<IUserNameObjectId> usernameObjectIds = userRepository.getUsernameObjectIds();
		response.setResult(usernameObjectIds);
		response.setErrorCode((short) 0);
		return response;
	}
}
