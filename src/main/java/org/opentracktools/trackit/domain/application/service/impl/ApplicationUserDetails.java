package org.opentracktools.trackit.domain.application.service.impl;

import org.opentracktools.trackit.domain.models.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Arpan Mukhopadhyay
 */
public class ApplicationUserDetails implements UserDetails {
  
  private final UserEntity userEntity;
  
  /**
   *
   * @param userEntity
   */
  public ApplicationUserDetails(UserEntity userEntity) {
    this.userEntity = userEntity;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
  
  @Override
  public String getPassword() {
    return userEntity.getPassword();
  }
  
  @Override
  public String getUsername() {
    return userEntity.getUsername();
  }
  
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  
  @Override
  public boolean isAccountNonLocked() {
    return !userEntity.isLocked();
  }
  
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    return !userEntity.isDeleted();
  }
}
