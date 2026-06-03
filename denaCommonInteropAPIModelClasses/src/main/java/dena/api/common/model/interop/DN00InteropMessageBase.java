package dena.api.common.model.interop;


import dena.api.common.model.interop.context.DN00InteropContext;
import dena.api.common.model.interop.context.DN00InteropProtocol;
import dena.api.common.model.oids.consent.DN00ConsentOIDs.DN00ConsentOID;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;

@Accessors(prefix = "_")
public abstract class DN00InteropMessageBase<D extends DN00IsInteropMessagePayload>
           implements DN00IsInteropMessage {

	private static final long serialVersionUID = -6514804597587776907L;
//////////////////////////////////////////////////////////////////////////////
//  FIELDS
//////////////////////////////////////////////////////////////////////////////
    @MarshallField(as="context")
    @Getter @Setter private DN00InteropContext _context;

    @MarshallField(as="protocol")
    @Getter @Setter private DN00InteropProtocol _protocol;

    @MarshallField(as="data")
    @Getter @Setter private D _data;
    
    @MarshallField(as="consentOid")
    @Getter @Setter private DN00ConsentOID _consentOid;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////    
    public DN00InteropMessageBase() {
		// default no-args constructor
	}
    public DN00InteropMessageBase(final DN00InteropContext context,
								  final DN00InteropProtocol protocol,
								  final D data,
								  final DN00ConsentOID consentOid) {
		_context = context;
		_protocol = protocol;
		_data = data;
		_consentOid = consentOid;
    }
	public DN00InteropMessageBase(final DN00InteropContext context,
								  final DN00InteropProtocol protocol,
								  final D data) {
		this(context,
			protocol,	
			data,
			null);		// consentOid
	 }
	public DN00InteropMessageBase(final DN00InteropContext context,
								  final D data) {
		this(context,
			null,		// protocol
			data,
			null);		// consentOid
	 }
	public DN00InteropMessageBase(final D data) {
		this(null,		// context
			 null,		// protocol
			 data,
			 null);		// consentOid
	 }
}
