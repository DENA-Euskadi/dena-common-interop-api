package dena.api.common.model.interop.response.error;

import dena.api.common.model.interop.DN00IsInteropMessagePayload;
import dena.api.common.model.interop.context.DN00InteropProtocol;
import dena.api.common.model.interop.response.DN00InteropResponseBase;
import lombok.Getter;
import lombok.Setter;
import r01f.objectstreamer.annotations.MarshallField;

public class DN00InteropResponseForError
     extends DN00InteropResponseBase<DN00InteropMessagePayloadForErrorResponse> {

	private static final long serialVersionUID = -7377055214326776824L;
/////////////////////////////////////////////////////////////////////////////////////////
//	FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * The payload of the request message that caused the error response
	 * (optional)
	 */
	@MarshallField(as="requestMessagePayload")
	@Getter @Setter private DN00IsInteropMessagePayload _requestMessagePayload;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////	
	public DN00InteropResponseForError() {
		// default no-args constructor
	}
	public DN00InteropResponseForError(final DN00InteropMessagePayloadForErrorResponse data,
									   final DN00InteropProtocol protocol,
									   final DN00IsInteropMessagePayload requestMessagePayload) {
		super(data);
		_requestMessagePayload = requestMessagePayload;
	}
	public DN00InteropResponseForError(final DN00InteropMessagePayloadForErrorResponse data,
									   final DN00IsInteropMessagePayload requestMessagePayload) {
		super(data);
		_requestMessagePayload = requestMessagePayload;
	}
	public DN00InteropResponseForError(final DN00InteropMessagePayloadForErrorResponse data) {
		super(data);
	}
}
