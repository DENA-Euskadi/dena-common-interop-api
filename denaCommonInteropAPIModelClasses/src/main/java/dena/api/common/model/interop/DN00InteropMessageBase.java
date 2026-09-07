package dena.api.common.model.interop;


import dena.api.common.interop.context.DN00InteropContext;
import dena.api.common.interop.context.DN00InteropProtocol;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;

@Accessors(prefix = "_")
public abstract class DN00InteropMessageBase<P>	// PAYLOAD
           implements DN00IsInteropMessage {

	private static final long serialVersionUID = -6514804597587776907L;
//////////////////////////////////////////////////////////////////////////////
//  FIELDS
//////////////////////////////////////////////////////////////////////////////
    @MarshallField(as="context")
    @Getter @Setter private DN00InteropContext _context;

    @MarshallField(as="protocol")
    @Getter @Setter private DN00InteropProtocol _protocol;

    @MarshallField(as="payload")
    @Getter @Setter private P _payload;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////    
    public DN00InteropMessageBase() {
		// default no-args constructor
	}
    public DN00InteropMessageBase(final DN00InteropContext context,
								  final DN00InteropProtocol protocol,
								  final P payload) {
		_context = context;
		_protocol = protocol;
		_payload = payload;
    }
	public DN00InteropMessageBase(final DN00InteropContext context,
								  final P payload) {
		this(context,
			null,		// protocol
			payload);
	}
	public DN00InteropMessageBase(final P payload) {
		this(null,		// context
			 null,		// protocol
			 payload);	// consentOid
	}
}
