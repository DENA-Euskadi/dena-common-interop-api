package dena.api.common.model.interop.request;


import dena.api.common.model.interop.DN00InteropMessageBase;
import dena.api.common.model.interop.DN00IsInteropMessagePayload;
import dena.api.common.model.interop.context.DN00InteropContext;
import dena.api.common.model.interop.context.DN00InteropProtocol;
import dena.api.common.model.oids.consent.DN00ConsentOIDs.DN00ConsentOID;
import lombok.experimental.Accessors;

@Accessors(prefix = "_")
public abstract class DN00InteropRequestBase<D extends DN00IsInteropMessagePayload>
			  extends DN00InteropMessageBase<D>
           implements DN00IsInteropRequest {

	private static final long serialVersionUID = -8613835531718678209L;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public DN00InteropRequestBase() {
		// default no-args constructor
	}
	public DN00InteropRequestBase(final DN00InteropContext context,
								  final DN00InteropProtocol protocol,
								  final D data,
								  final DN00ConsentOID consentOid) {
		super(context,
			  protocol,
			  data,
			  consentOid);
	}
	public DN00InteropRequestBase(final DN00InteropContext context,
								  final DN00InteropProtocol protocol,
								  final D data) {
		super(context,
			  protocol,	
			  data);	
	}
	public DN00InteropRequestBase(final DN00InteropContext context,
								  final D data) {
		super(context,
			  data);
	}
	public DN00InteropRequestBase(final D data) {
		super(data);
	}
}
