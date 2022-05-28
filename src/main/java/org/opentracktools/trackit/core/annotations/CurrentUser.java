package org.opentracktools.trackit.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * @author Arpan Mukhopadhyay
 */
@AuthenticationPrincipal
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
