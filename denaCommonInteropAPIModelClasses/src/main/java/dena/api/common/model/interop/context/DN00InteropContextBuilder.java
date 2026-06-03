package dena.api.common.model.interop.context;

import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropDestinationPartyID;
import dena.api.common.model.interop.oids.DN00InteropIDs.DN00InteropOriginPartyID;
import dena.api.common.model.refs.interopconfig.DN00DataTypeRef;
import dena.api.common.model.refs.orgconfig.DN00OrgAdminRef;
import dena.api.common.model.refs.person.DN00PersonRef;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import r01f.model.builders.BuilderBuildStep;
import r01f.patterns.IsBuilder;
import r01f.patterns.IsBuilderStep;

/**
 *
 */
/**
 * Builder for {@link DN00InteropContext} instances.
 *
 * <p>This class implements a step-builder pattern using nested step classes so that callers
 * are forced to provide required properties in the correct order. Typical construction
 * follows the chain:
 *
 * <pre>
 * DN00InteropContext ctx = DN00InteropContextBuilder.createMessageOfType(DN00InteropMessageType.MY_MESSAGE_TYPE)
	 *     												 .forDataType(myDataTypeRef)
	 *     												 .withFlowDirection(DN00InteropFlowDirection.REQUEST)
	 *     												 .from(myOriginPartyId)
	 *     												 .to(myDestinationPartyId)
	 *     												 .withAdministration(myAdminRef)          // -> then either
	 *     												 .about(myPersonRef)          // -> build step
 *     												 .build();
 * </pre>
 *
 * <p>Use the provided static entry point {@link #createMessageOfType(DN00InteropMessageType)}
 * to start building.
 */
public abstract class DN00InteropContextBuilder 
		   implements IsBuilder {    
////////// ----- MESSAGE 
	public static DN00InteropContextBuilderFlowDirectionStep createMessageOfType(final DN00InteropMessageType messageType) {
		return new DN00InteropContextBuilder() { /* nothing */ }
					.new DN00InteropContextBuilderFlowDirectionStep(messageType);
	}
////////// ----- FLOW DATA
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderFlowDirectionStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		public DN00InteropContextBuilderOriginPartyStep withFlowDirection(final DN00InteropFlowDirection flowDirection) {
			return new DN00InteropContextBuilderOriginPartyStep(_messageType,
																flowDirection);
		}
	}
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderOriginPartyStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		private final DN00InteropFlowDirection _flowDirection;
		
		public DN00InteropContextBuilderDestinationPartyStep from(final DN00InteropOriginPartyID originPartyId) {
			return new DN00InteropContextBuilderDestinationPartyStep(_messageType,
																     _flowDirection,originPartyId);
		}
	}
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderDestinationPartyStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		private final DN00InteropFlowDirection _flowDirection;
		private final DN00InteropOriginPartyID _originPartyId;
		
		public DN00InteropContextBuilderDataTypeStep to(final DN00InteropDestinationPartyID destinationPartyId) {
			return new DN00InteropContextBuilderDataTypeStep(_messageType,
															 _flowDirection,_originPartyId,destinationPartyId);
		}
	}
////////// -----  OBJECT REFS
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderDataTypeStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		private final DN00InteropFlowDirection _flowDirection;
		private final DN00InteropOriginPartyID _originPartyId;
		private final DN00InteropDestinationPartyID _destinationPartyId;
		
		public DN00InteropContextBuilderAdministrationStep forDataType(final DN00DataTypeRef dataType) {
			return new DN00InteropContextBuilderAdministrationStep(_messageType,
															 	  _flowDirection,_originPartyId,_destinationPartyId,
															 	  dataType);
		}
		public DN00InteropContext build() {
			return new DN00InteropContextBuilderBuildStep(_messageType,
											  			  _flowDirection,_originPartyId,_destinationPartyId,
											  			  null,null,null)
							.build();
		}
	}
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderAdministrationStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		private final DN00InteropFlowDirection _flowDirection;
		private final DN00InteropOriginPartyID _originPartyId;
		private final DN00InteropDestinationPartyID _destinationPartyId;
		
		private final DN00DataTypeRef _dataType;
		
		public DN00InteropContextBuilderSubjectPersonStep withAdministration(final DN00OrgAdminRef administrationRef) {
			return new DN00InteropContextBuilderSubjectPersonStep(_messageType,
											  			  		  _flowDirection,_originPartyId,_destinationPartyId,
											  			  		  _dataType,administrationRef);
		}
		
		public DN00InteropContext build() {
			return new DN00InteropContextBuilderBuildStep(_messageType,
											  			  _flowDirection,_originPartyId,_destinationPartyId,
											  			  _dataType,null,null)	// no admin, no person
							.build();
		}
	}
	@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
	public class DN00InteropContextBuilderSubjectPersonStep 
	  implements IsBuilderStep {
		private final DN00InteropMessageType _messageType;
		
		private final DN00InteropFlowDirection _flowDirection;
		private final DN00InteropOriginPartyID _originPartyId;
		private final DN00InteropDestinationPartyID _destinationPartyId;
		
		private final DN00DataTypeRef _dataType;
		private final DN00OrgAdminRef _administrationRef;
		
		public DN00InteropContextBuilderBuildStep about(final DN00PersonRef subjectPerson) {
			return new DN00InteropContextBuilderBuildStep(_messageType,
											  			  _flowDirection,_originPartyId,_destinationPartyId,
											  			  _dataType,_administrationRef,subjectPerson);
		}
		public DN00InteropContext build() {
			return new DN00InteropContextBuilderBuildStep(_messageType,
											  			  _flowDirection,_originPartyId,_destinationPartyId,
											  			  _dataType,_administrationRef,null)
							.build();
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
//	
/////////////////////////////////////////////////////////////////////////////////////////	
	public class DN00InteropContextBuilderBuildStep
		 extends BuilderBuildStep<DN00InteropContext> {
		public DN00InteropContextBuilderBuildStep(final DN00InteropMessageType messageType,
											   	  final DN00InteropFlowDirection flowDirection,final DN00InteropOriginPartyID originPartyId,final DN00InteropDestinationPartyID destinationPartyId,
											   	  final DN00DataTypeRef dataType,final DN00OrgAdminRef adminRef,final DN00PersonRef personRef) {
			super(new DN00InteropContext(messageType,
										 flowDirection,originPartyId,destinationPartyId,
										 null,
										 null,
										 null,
										 dataType,personRef,adminRef));
		}
	}
}
