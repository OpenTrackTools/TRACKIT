/**
 *
 */
package org.opentracktools.trackit.web.views;

import org.opentracktools.trackit.infra.repository.UserRepository;
import org.opentracktools.trackit.web.forms.commons.UserDropDownEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Component("userUtils")
public class WebUserHelperService {
  
  @Autowired
  private UserRepository userRepository;
  
  /**
   *
   * @return
   */
  public List<UserDropDownEntry> listUsers() {
    List<UserDropDownEntry> userDropDownList = new ArrayList<>();
    userRepository.getUsernameObjectIds().forEach(e -> {
      userDropDownList.add(new UserDropDownEntry(e.getObjectId(), e.getUsername(), null));
    });
    return userDropDownList;
  }
}
