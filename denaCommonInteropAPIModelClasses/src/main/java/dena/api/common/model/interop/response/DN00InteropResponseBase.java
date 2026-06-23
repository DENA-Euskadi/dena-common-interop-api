package dena.api.common.model.interop.response;

import dena.api.common.model.interop.DN00InteropMessageBase;
import dena.api.common.model.interop.DN00IsInteropMessage;
import dena.api.common.model.interop.DN00IsInteropMessagePayload;
import dena.api.common.model.interop.context.DN00InteropContext;
import dena.api.common.model.interop.context.DN00InteropProtocol;
import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropResponseStatusCode;
import dena.api.common.model.oids.consent.DN00ConsentOIDs.DN00ConsentOID;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;

@Accessors(prefix = "_")
public abstract class DN00InteropResponseBase<D extends DN00IsInteropMessagePayload>
			  extends DN00InteropMessageBase<D>
           implements DN00IsInteropMessage {

	 private static final long serialVersionUID = -8193992284627836006L;
//////////////////////////////////////////////////////////////////////////////
//       FIELDS
//////////////////////////////////////////////////////////////////////////////
	/**
	 * The status code of the response (e.g. OK, ERROR, etc.)
	 */
	@MarshallField(as = "code")
    @Getter @Setter private DN00InteropResponseStatus _status;
	/**
	 * An id of the status defined by the error source (e.g. the service that generated the error)
	 * (optiona) 
	 */
	@MarshallField(as="errorId")
	@Getter @Setter private DN00InteropResponseStatusCode _code;	
    /**
     * Details about the status (e.g. error details, etc.)
     * (optional)
     */
    @MarshallField(as = "details")
    @Getter @Setter private DN00InteropResponseStatusDetails _details;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////    
    public DN00InteropResponseBase() {
		// default no-args constructor
    }
    public DN00InteropResponseBase(final DN00InteropContext context,
								   final DN00InteropProtocol protocol,
								   final D data,
								   final DN00ConsentOID consentOid) {
    	super(context,
    		  protocol,
    		  data,
    		  consentOid);
    }
    public DN00InteropResponseBase(final DN00InteropContext context,
								   final DN00InteropProtocol protocol,
								   final D data) {
		super(context,
			  protocol,
			  data);	
	}
    public DN00InteropResponseBase(final DN00InteropContext context,
								   final D data) {
    	super(context,
			  data);
    }
    public DN00InteropResponseBase(final D data) {
    	super(data);
    }
}
