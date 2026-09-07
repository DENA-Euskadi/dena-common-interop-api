package dena.api.common.model.interop;

import dena.api.common.interop.context.DN00InteropContext;
import dena.api.common.interop.context.DN00InteropProtocol;

public interface DN00IsInteropMessage
	     extends DN00IsInteropModelObject {
/////////////////////////////////////////////////////////////////////////////////////////
//	
/////////////////////////////////////////////////////////////////////////////////////////
	public DN00InteropContext getContext();
	public DN00InteropProtocol getProtocol();
	
	public <P> P getPayload();
}
