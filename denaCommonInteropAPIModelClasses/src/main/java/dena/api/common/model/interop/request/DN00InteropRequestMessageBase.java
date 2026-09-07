package dena.api.common.model.interop.request;


import dena.api.common.interop.context.DN00InteropContext;
import dena.api.common.interop.context.DN00InteropProtocol;
import dena.api.common.model.interop.DN00InteropMessageBase;
import dena.api.common.model.oids.consent.DN00ConsentOIDs.DN00ConsentOID;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;

@Accessors(prefix = "_")
public abstract class DN00InteropRequestMessageBase<P>
			  extends DN00InteropMessageBase<P>
           implements DN00IsInteropRequestMessage {

	private static final long serialVersionUID = -8613835531718678209L;
/////////////////////////////////////////////////////////////////////////////////////////
//	FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
    @MarshallField(as="consentOid")
    @Getter @Setter private DN00ConsentOID _consentOid;	
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public DN00InteropRequestMessageBase() {
		// default no-args constructor
	}
	public DN00InteropRequestMessageBase(final DN00InteropContext context,
								  		 final DN00InteropProtocol protocol,
								  		 final P data,
								  		 final DN00ConsentOID consentOid) {
		super(context,
			  protocol,
			  data);
		_consentOid = consentOid;
	}
	public DN00InteropRequestMessageBase(final DN00InteropContext context,
								  		 final DN00InteropProtocol protocol,
								  		 final P data) {
		super(context,
			  protocol,	
			  data);	
	}
	public DN00InteropRequestMessageBase(final DN00InteropContext context,
								  		 final P data) {
		super(context,
			  data);
	}
	public DN00InteropRequestMessageBase(final P data) {
		super(data);
	}
}
