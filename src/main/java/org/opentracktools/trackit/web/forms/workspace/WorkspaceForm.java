/**
 *
 */
package org.opentracktools.trackit.web.forms.workspace;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.opentracktools.trackit.domain.models.common.Type;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@NoArgsConstructor
@Data
public class WorkspaceForm {
  
  private String name;
  private String description;
  private String notes;
  private String details;
  private String guideline;
  private String user;
  private Type type;
  private String dateFormat;
  private String dateTimeFormat;
  private String featurePrefix;
  private String storyPrefix;
  private String epicPrefix;
  private String defectPrefix;
  private String taskPrefix;
}
