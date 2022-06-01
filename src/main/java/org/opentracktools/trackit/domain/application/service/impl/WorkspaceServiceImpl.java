/**
 * 
 */
package org.opentracktools.trackit.domain.application.service.impl;

import java.util.Date;

import org.opentracktools.trackit.domain.models.user.UserEntity;
import org.opentracktools.trackit.domain.models.workspace.WorkspaceEntity;
import org.opentracktools.trackit.infra.repository.UserRepository;
import org.opentracktools.trackit.infra.repository.WorkspaceRepository;
import org.opentracktools.trackit.web.forms.workspace.WorkspaceForm;
import org.opentracktools.trackit.web.response.WorkspaceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Service
@Slf4j
public class WorkspaceServiceImpl {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @param form
	 * @return
	 */
	public WorkspaceServiceResponse create(@NotNull final WorkspaceForm form) {
		WorkspaceServiceResponse response = new WorkspaceServiceResponse();
		
		WorkspaceEntity workspaceEntity = new WorkspaceEntity();
		
		workspaceEntity.setCreatedAt(new Date());
		workspaceEntity.setName(form.getName());
		
		long start = System.nanoTime();
		UserEntity userEntity = userRepository.findByObjectId(form.getUser()).orElse(null);
		log.info("Test Entity fetched in {} ns \n{}\n",(System.nanoTime() - start), userEntity);
		if (null != userEntity) {
			workspaceEntity.setOwner(userEntity);
			try {
				workspaceRepository.save(workspaceEntity);
				response.setErrorCode((short) 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//TODO - Will generate the error message accordingly.
		}
		return response;
	}
}
