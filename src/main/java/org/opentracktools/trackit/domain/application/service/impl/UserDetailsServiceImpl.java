package org.opentracktools.trackit.domain.application.service.impl;

import org.opentracktools.trackit.domain.models.user.UserEntity;
import org.opentracktools.trackit.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Arpan Mukhopadhyay
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepository;
  
  
  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    if (null == login) throw new UsernameNotFoundException("No user found with login " + null);
    UserEntity retrievedUser;
    if (login.contains("@")) {
      //Find by email
      retrievedUser = userRepository.findUserEntityByEmail(login).orElse(null);
    } else {
      //Find by username
      retrievedUser = userRepository.findUserEntityByUsername(login).orElse(null);
    }
    if (null == retrievedUser) {
      throw new UsernameNotFoundException("No user found with login " + login);
    }
    return new ApplicationUserDetails(retrievedUser);
  }
}
