/**
 * 
 */
package org.opentracktools.trackit.domain.models.workspace;

import java.io.Serial;

import org.opentracktools.trackit.domain.models.common.BaseEntity;
import org.opentracktools.trackit.domain.models.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
	@JoinColumn(name = "owner_obj_id", referencedColumnName = "object_id")
	private String ownerObjId;
}
