package dena.api.common.model.interop.response;

import dena.api.common.model.DN00IsDENAModelObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;


@Accessors(prefix = "_")
@MarshallType(as="interopStatusDetails")
public abstract class DN00InteropResponseStatusDetails
           implements DN00IsDENAModelObject {

	private static final long serialVersionUID = 1869386784214215579L;
/////////////////////////////////////////////////////////////////////////////////////////
//	FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Any details about the error (e.g. stack trace, error message, etc.) 
	 */
	@MarshallField(as="details",escape=true)
	@Getter @Setter private String _details;
}
