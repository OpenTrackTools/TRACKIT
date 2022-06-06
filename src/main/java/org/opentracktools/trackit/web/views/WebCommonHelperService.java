/**
 *
 */
package org.opentracktools.trackit.web.views;

import org.opentracktools.trackit.web.forms.commons.TypeDropDownEntry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arixion
 *
 */
@Component("commonUtils")
public class WebCommonHelperService {
  
  /**
   *
   * @return
   */
  public List<TypeDropDownEntry> listTypes() {
    List<TypeDropDownEntry> types = new ArrayList<>();
    types.add(new TypeDropDownEntry("private", null, "Private", null));
    types.add(new TypeDropDownEntry("public", null, "Public", null));
    return types;
  }
}
