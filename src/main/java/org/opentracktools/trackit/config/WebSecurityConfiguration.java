package org.opentracktools.trackit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpan Mukhopadhyay
 */
@Slf4j
@EnableWebSecurity
public class WebSecurityConfiguration {
  
  private static final String[] NON_SECURE_ENDPOINTS = new String[]{"/error", "/signin", "/signout", "/signup"};
  
  private static final String[] WEB_RESOURCE_ENDPOINTS = new String[]{"/css/**", "/js/**", "/images/**",
      "/fonts/**", "/favicon.ico"};
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    if (log.isTraceEnabled()) {
      log.trace("Allowed urls{}", Arrays.asList(NON_SECURE_ENDPOINTS, WEB_RESOURCE_ENDPOINTS));
    }
    
    http.cors().and()
        .authorizeHttpRequests((auth) -> auth.antMatchers(NON_SECURE_ENDPOINTS).permitAll()
            .antMatchers(WEB_RESOURCE_ENDPOINTS).permitAll().anyRequest().authenticated())
        .formLogin().loginPage("/signin").loginProcessingUrl("/signin").usernameParameter("login")
        .passwordParameter("password").and().logout().logoutUrl("/signout").clearAuthentication(true)
        .logoutSuccessUrl("/signin").and().cors();
    
    return http.build();
  }
  
  @Bean
  public PasswordEncoder delegatingPasswordEncoder() {
    Map<String, PasswordEncoder> encoders = new HashMap<>();
    Argon2PasswordEncoder defaultEncoder = new Argon2PasswordEncoder(16, 32, 1, 4096, 7);
    encoders.put("argon2id", defaultEncoder);
    DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder("argon2id", encoders);
    delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
    return delegatingPasswordEncoder;
  }
}
