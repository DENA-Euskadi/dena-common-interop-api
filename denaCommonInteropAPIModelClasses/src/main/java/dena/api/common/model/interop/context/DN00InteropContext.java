	package dena.api.common.model.interop.context;

import java.util.Collection;

import dena.api.common.context.DN00SecurityContext;
import dena.api.common.model.interop.DN00IsInteropModelObject;
import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropComponentID;
import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropDestinationPartyID;
import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropOriginPartyID;
import dena.api.common.model.interop.oids.DN00InteropOIDs.DN00MessageCorrelationOID;
import dena.api.common.model.oids.security.DN00SecurityOIDs.DN00ClientInstallmentOID;
import dena.api.common.model.refs.interopconfig.DN00DataTypeRef;
import dena.api.common.model.refs.orgconfig.DN00OrgAdminRef;
import dena.api.common.model.refs.person.DN00PersonRef;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.debug.Debuggable;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;
import r01f.types.JsonString;
import r01f.util.types.Strings;


/**
 * Context for all interop messages
 * @see DN00InteropContextBuilder
 * @see DN00InteropContextValidator
 */
@Accessors(prefix = "_")
@MarshallType(as = "context")
public class DN00InteropContext
  implements DN00IsInteropModelObject,
  			 Debuggable {
	
	private static final long serialVersionUID = 7570079814902630391L;
/////////////////////////////////////////////////////////////////////////////////////////
//	FIELDS
/////////////////////////////////////////////////////////////////////////////////////////	
////////// ----- MESSAGE    
    @MarshallField(as="messageType")
    @Getter @Setter private DN00InteropMessageType _messageType;
    
    @MarshallField(as="messageCorrelationId") //its a oid
    @Getter @Setter private DN00MessageCorrelationOID _messageCorrelationId;
////////// ----- FLOW DATA
    @MarshallField(as="flowDirection")
    @Getter @Setter private DN00InteropFlowDirection _flowDirection;
    
    @MarshallField(as="originPartyId")
    @Getter @Setter private DN00InteropOriginPartyID  _originPartyId;

    @MarshallField(as="destinationPartyId")
    @Getter @Setter private DN00InteropDestinationPartyID _destinationPartyId; 
    
    @MarshallField(as="interopRouteData")
    @Getter @Setter private Collection<DN00IteropRouteDataItem> _interopRouteData;
    
////////// -----  CLIENT DEVICE
    @MarshallField(as="clientDeviceOid")
    @Getter @Setter private DN00ClientInstallmentOID _clientInstallmentOid;
    
    @MarshallField(as="userAgent")
    @Getter @Setter private JsonString _userAgent;	// json contained user agent info (see r01f.web.useragent.UserAgentParser for creating the json string from the user agent header)
    
////////// -----  OBJECT REFS
    @MarshallField(as="dataType")
    @Getter @Setter private DN00DataTypeRef _dataType;

    @MarshallField(as="subjectPerson")
    @Getter @Setter private DN00PersonRef _subjectPerson;
	
    @MarshallField(as="administration")
    @Getter @Setter private DN00OrgAdminRef _administration;
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////    
    public DN00InteropContext() {
		_messageCorrelationId = DN00MessageCorrelationOID.supply();
	}
    public DN00InteropContext(final DN00InteropMessageType msgType,
    						  final DN00MessageCorrelationOID messageCorrelationId,
    						  final DN00InteropFlowDirection flowDirection,final DN00InteropOriginPartyID originPartyId,final DN00InteropDestinationPartyID destinationPartyId,
    						  final Collection<DN00IteropRouteDataItem> interopRouteData,
    						  final DN00ClientInstallmentOID clientInstallmentOid,
    						  final JsonString userAgent) {
    	_messageType = msgType;
    	_messageCorrelationId = messageCorrelationId;
    	_flowDirection = flowDirection;
    	_destinationPartyId = destinationPartyId;
    	_originPartyId = originPartyId;
    	_interopRouteData = interopRouteData;
    	_clientInstallmentOid = clientInstallmentOid;
    	_userAgent = userAgent;
    }
    public DN00InteropContext(final DN00InteropMessageType msgType,
    						  final DN00MessageCorrelationOID messageCorrelationId,
    						  final DN00InteropFlowDirection flowDirection,final DN00InteropOriginPartyID originPartyId,final DN00InteropDestinationPartyID destinationPartyId,
    						  final Collection<DN00IteropRouteDataItem> interopRouteData,
    						  final DN00ClientInstallmentOID clientInstallmentOid,
    						  final JsonString userAgent,
    						  final DN00DataTypeRef dataType,final DN00PersonRef subjectPerson,final DN00OrgAdminRef administration) {
    	this(msgType,
    		 messageCorrelationId,flowDirection,originPartyId,destinationPartyId,interopRouteData,
    		 clientInstallmentOid,
    		 userAgent);
    	_dataType = dataType;
    	_subjectPerson = subjectPerson;
    	_administration = administration;
    }
    public DN00InteropContext(final DN00InteropMessageType msgType,
    						  final DN00InteropFlowDirection flowDirection,final DN00InteropOriginPartyID originPartyId,final DN00InteropDestinationPartyID destinationPartyId,
    						  final Collection<DN00IteropRouteDataItem> interopRouteData,
    						  final DN00ClientInstallmentOID clientInstallmentOid,
    						  final JsonString userAgent) {
    	this(msgType,
    		 DN00MessageCorrelationOID.supply(),
			 flowDirection,originPartyId,destinationPartyId,
			 interopRouteData,
			 clientInstallmentOid,userAgent);
    }
    public DN00InteropContext(final DN00InteropMessageType msgType,
    						  final DN00InteropFlowDirection flowDirection,final DN00InteropOriginPartyID originPartyId,final DN00InteropDestinationPartyID destinationPartyId,
    						  final Collection<DN00IteropRouteDataItem> interopRouteData,
    						  final DN00ClientInstallmentOID clientInstallmentOid,
    						  final JsonString userAgent,
    						  final DN00DataTypeRef dataType,final DN00PersonRef subjectPerson,final DN00OrgAdminRef administration) {
    	this(msgType,
    		 DN00MessageCorrelationOID.supply(),
			 flowDirection,originPartyId,destinationPartyId,interopRouteData,
			 clientInstallmentOid,userAgent,
			 dataType,subjectPerson,administration);
    }
    public DN00InteropContext(final DN00SecurityContext securityContext) {
    	_messageType = securityContext.getMessageType();    	
    	_messageCorrelationId = securityContext.getMessageCorrelationId();
    	_flowDirection = securityContext.getFlowDirection();
    	_originPartyId = securityContext.getOriginPartyId();
    	_destinationPartyId = securityContext.getDestinationPartyId();
    	_interopRouteData = securityContext.getInteropRouteData();
    	_clientInstallmentOid = securityContext.getClientInstallmentOid();
	}
/////////////////////////////////////////////////////////////////////////////////////////
//	INTEROP ROUTE
/////////////////////////////////////////////////////////////////////////////////////////
    public DN00InteropContext addRouteItem(final DN00IteropRouteDataItem item) {
		_interopRouteData.add(item);
		return this;
	}
    public boolean containsRouteItem(final DN00InteropComponentID componentId) {
		return _interopRouteData != null
			&& _interopRouteData.stream()
								.anyMatch(item -> item.getComponentId().is(componentId));
    }
/////////////////////////////////////////////////////////////////////////////////////////
//	
/////////////////////////////////////////////////////////////////////////////////////////
    public boolean isMessageOfType(final DN00InteropMessageType type) {
    	return _messageType != null
			&& _messageType.equals(type);
    }
    public boolean isMessageWithDirection(final DN00InteropFlowDirection flowDirection) {
		return _flowDirection != null
			&& _flowDirection.equals(flowDirection);
    }
/////////////////////////////////////////////////////////////////////////////////////////
//	DEBUG
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public CharSequence debugInfo() {
		return Strings.customized("""
								  message: type={} / correlationId={}
								  flow: direction={} / originPartyId={} / destinationPartyId={}
  								  dataType: {}
								  subject person: {}
								  administration: {}
								  """,
								  _messageType,_messageCorrelationId,
								  _flowDirection,_originPartyId,_destinationPartyId,
								  _dataType,
								  _subjectPerson,
								  _administration);
	}
}
