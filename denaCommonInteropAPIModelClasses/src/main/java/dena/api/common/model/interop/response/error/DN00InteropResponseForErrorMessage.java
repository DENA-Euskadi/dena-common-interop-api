package dena.api.common.model.interop.response.error;

import dena.api.common.interop.context.DN00InteropProtocol;
import dena.api.common.model.interop.response.DN00InteropResponseMessageBase;
import lombok.Getter;
import lombok.Setter;
import r01f.objectstreamer.annotations.MarshallField;

public class DN00InteropResponseForErrorMessage<P>	// payload
     extends DN00InteropResponseMessageBase<DN00InteropMessagePayloadForErrorResponse> {

	private static final long serialVersionUID = -7377055214326776824L;
/////////////////////////////////////////////////////////////////////////////////////////
//	FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * The payload of the request message that caused the error response
	 * (optional)
	 */
	@MarshallField(as="requestMessagePayload")
	@Getter @Setter private P _requestMessagePayload;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////	
	public DN00InteropResponseForErrorMessage() {
		// default no-args constructor
	}
	public DN00InteropResponseForErrorMessage(final DN00InteropMessagePayloadForErrorResponse data,
									   		  final DN00InteropProtocol protocol,
									   		  final P requestMessagePayload) {
		super(data);
		_requestMessagePayload = requestMessagePayload;
	}
	public DN00InteropResponseForErrorMessage(final DN00InteropMessagePayloadForErrorResponse data,
									   		  final P requestMessagePayload) {
		super(data);
		_requestMessagePayload = requestMessagePayload;
	}
	public DN00InteropResponseForErrorMessage(final DN00InteropMessagePayloadForErrorResponse data) {
		super(data);
	}
}
