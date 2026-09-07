package dena.api.common.model.interop.request;

import dena.api.common.model.interop.DN00IsInteropMessage;
import dena.api.common.model.oids.consent.DN00ConsentOIDs.DN00ConsentOID;

public interface DN00IsInteropRequestMessage
	     extends DN00IsInteropMessage {
	
	public DN00ConsentOID getConsentOid();
}
