package dena.api.common.model.interop.context;

import dena.api.common.model.interop.DN00IsInteropModelObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;
import r01f.types.TimeLapse;
import r01f.types.url.UrlTemplateCollection;

/**
 * DENA interoperability protocol for admin connections.
 */
@Accessors(prefix = "_")
@MarshallType(as = "protocol")
public class DN00InteropProtocol
  implements DN00IsInteropModelObject {

	private static final long serialVersionUID = 8947635803092936902L;
//////////////////////////////////////////////////////////////////////////////
// 	FIELDS
//////////////////////////////////////////////////////////////////////////////
    @MarshallField(as = "urls")
    @Getter @Setter private UrlTemplateCollection _urls;

    @MarshallField(as = "timeOut")
    @Getter @Setter private TimeLapse _timeOut; // [TODO] what is this¿?
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR	
/////////////////////////////////////////////////////////////////////////////////////////
    public DN00InteropProtocol() {
		// default no-args constructor
	}
    public DN00InteropProtocol(final UrlTemplateCollection urls,
							   final TimeLapse timeOut) {
		_urls = urls;
		_timeOut = timeOut;
	}
}
