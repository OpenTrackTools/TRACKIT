package org.opentracktools.trackit.domain.models.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@Setter
public class BaseEntity implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;
  
  @Column(nullable = false, unique = true)
  private String objectId;
  
  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;
  
  @Column(name = "deleted_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deletedAt;
  
  @Column(name = "is_deleted")
  private boolean deleted = false;
  
  /**
   *
   */
  public BaseEntity() {
    this.objectId = UUID.randomUUID().toString().replace("-", "");
  }
}
