package org.opentracktools.trackit.infra.repository;

import org.opentracktools.trackit.domain.models.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
}
