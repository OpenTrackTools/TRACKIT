/**
 * 
 */
package org.opentracktools.trackit.domain.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.opentracktools.trackit.infra.repository.UserRepository;
import org.opentracktools.trackit.web.forms.commons.UserDropDownEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Component("userViewUtils")
public class UserViewUrilService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<UserDropDownEntry> listUsers() {
		List<UserDropDownEntry> userDropDownList = new ArrayList<>();
		userRepository.getUsernameObjectIds().forEach(e -> {
			userDropDownList.add(new UserDropDownEntry(e.getObjectId(), e.getUsername()));
		});
		return userDropDownList;
	}
}
