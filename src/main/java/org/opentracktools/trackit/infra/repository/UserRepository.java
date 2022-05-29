package org.opentracktools.trackit.infra.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.opentracktools.trackit.domain.models.user.UserEntity;
import org.opentracktools.trackit.domain.models.user.UserNameObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Arpan Mukhopadhyay
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	/**
	 *
	 * @param email
	 * @return
	 */
	@Query("select u from UserEntity u where u.deleted = false and u.locked = false and u.email = :email")
	Optional<UserEntity> findUserEntityByEmail(@Param("email") String email);

	/**
	 *
	 * @param username
	 * @return
	 */
	@Query("select u from UserEntity u where u.deleted = false and u.locked = false and u.username = :username")
	Optional<UserEntity> findUserEntityByUsername(@Param("username") String username);
	
	/**
	 * 
	 * @return
	 */
	@Query("select u.objectId as objectId, u.username as username from UserEntity u where u.locked = false")
	Collection<UserNameObject> getUsernameObjectIds();
	
	/**
	 * 
	 * @return
	 */
	@Query("from UserEntity u where u.locked = false and u.deleted = false")
	List<UserEntity> listAllActiveUser();
}
