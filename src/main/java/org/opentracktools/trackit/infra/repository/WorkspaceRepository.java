/**
 * 
 */
package org.opentracktools.trackit.infra.repository;

import org.opentracktools.trackit.domain.models.workspace.WorkspaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author arixion
 *
 */
@Repository
public interface WorkspaceRepository extends JpaRepository<WorkspaceEntity, Long> {

}
