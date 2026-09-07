package dena.api.common.model.interop.response;

import dena.api.common.interop.context.DN00InteropContext;
import dena.api.common.interop.context.DN00InteropProtocol;
import dena.api.common.model.interop.DN00InteropMessageBase;
import dena.api.common.model.oids.interop.DN00InteropIDs.DN00InteropResponseStatusCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;

@Accessors(prefix = "_")
public abstract class DN00InteropResponseMessageBase<P>
			  extends DN00InteropMessageBase<P>
           implements DN00IsInteropResponseMessage {

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
    public DN00InteropResponseMessageBase() {
		// default no-args constructor
    }
    public DN00InteropResponseMessageBase(final DN00InteropContext context,
								   		  final DN00InteropProtocol protocol,
								   		  final P data) {
		super(context,
			  protocol,
			  data);	
	}
    public DN00InteropResponseMessageBase(final DN00InteropContext context,
								   		  final P data) {
    	super(context,
			  data);
    }
    public DN00InteropResponseMessageBase(final P data) {
    	super(data);
    }
}
