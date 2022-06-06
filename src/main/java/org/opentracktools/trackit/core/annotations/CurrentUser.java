package org.opentracktools.trackit.core.annotations;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Arpan Mukhopadhyay
 */
@AuthenticationPrincipal
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
