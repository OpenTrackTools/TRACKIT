/**
 *
 */
package org.opentracktools.trackit.domain.models.workspace;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.opentracktools.trackit.domain.models.common.BaseEntity;
import org.opentracktools.trackit.domain.models.common.Type;
import org.opentracktools.trackit.domain.models.user.UserEntity;

import java.io.Serial;
import java.util.UUID;

/**
 * @author Arpan Mukhopadhyay
 *
 */
@Entity
@Table(name = "workspaces", indexes = @Index(unique = true, name = "index_name_on_workspaces", columnList = "name"))
@Getter
@Setter
public class WorkspaceEntity extends BaseEntity {
  
  @Serial
  private static final long serialVersionUID = -6598692059097592596L;
  
  @NaturalId
  @Column(name = "object_id", nullable = false, unique = true)
  private String objectId;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "notes")
  private String notes;
  
  @Column(name = "details")
  private String details;
  
  @Column(name = "guidelines")
  private String guidelines;
  
  @Column(name = "icon")
  private String icon;
  
  @Column(name = "type", nullable = false)
  private Type tpye = Type.PRIVATE;
  
  @Column(name = "story_prefix", nullable = false)
  private String storyPrefix = "US";
  
  @Column(name = "feature_prefix", nullable = false)
  private String featurePrefix = "F";
  
  @Column(name = "epic_prefix", nullable = false)
  private String epicPrefix = "EP";
  
  @Column(name = "task_prefix", nullable = false)
  private String taskPrefix = "TA";
  
  @Column(name = "defect_prefix", nullable = false)
  private String defectPrefix = "D";
  
  @Column(name = "date_format", nullable = false)
  private String dateFormat = "";
  
  @Column(name = "datetime_format", nullable = false)
  private String dateTimeFormat = "";
  
  @Column(name = "timezone", nullable = false)
  private String timezone = "UTC";
  
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
  @JoinColumn(name = "owner_obj_id", referencedColumnName = "object_id")
  private UserEntity owner;
  
  /**
   *
   */
  public WorkspaceEntity() {
    this.objectId = UUID.randomUUID().toString().replace("-", "");
  }
}
