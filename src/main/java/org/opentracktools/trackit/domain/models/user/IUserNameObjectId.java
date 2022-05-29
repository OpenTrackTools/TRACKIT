/**
 * 
 */
package org.opentracktools.trackit.domain.models.user;

/**
 * @author Arpan Mukhopadhyay
 *
 */
public interface IUserNameObjectId {

	/**
	 * Fetches the username from the projection and returns it.
	 * @return the username
	 */
	String getUsername();
	
	/**
	 * Fetches the objectId from the projection and returns it.
	 * @return the objecId
	 */
	String getObjectId();
}
