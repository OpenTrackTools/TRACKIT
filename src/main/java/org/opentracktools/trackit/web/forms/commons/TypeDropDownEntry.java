/**
 * 
 */
package org.opentracktools.trackit.web.forms.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arixion
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDropDownEntry {

	private String value;
	private String pic;
	private String label;
	private String subLabel;
	
}
