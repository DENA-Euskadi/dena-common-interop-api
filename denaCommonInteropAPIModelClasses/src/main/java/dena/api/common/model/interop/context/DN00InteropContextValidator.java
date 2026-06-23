package dena.api.common.model.interop.context;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import r01f.validation.ObjectValidationResult;
import r01f.validation.ObjectValidationResultBuilder;
import r01f.validation.Validates;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class DN00InteropContextValidator {
/////////////////////////////////////////////////////////////////////////////////////////
//	
/////////////////////////////////////////////////////////////////////////////////////////	
	public static Validates<DN00InteropContext> createContextValidator() {
		return new Validates<DN00InteropContext>() {
						@Override
						public ObjectValidationResult<DN00InteropContext> validate(final DN00InteropContext ctx) {
							/////////// --- MESSAGE
							if (ctx.getMessageType() == null) return ObjectValidationResultBuilder.on(ctx)
																								  .isNotValidBecause("message type cannot be null");
							if (ctx.getDataType() == null) return ObjectValidationResultBuilder.on(ctx)
																							   .isNotValidBecause("data type type cannot be null");
							if (ctx.getMessageCorrelationId() == null) return ObjectValidationResultBuilder.on(ctx)
																								  		   .isNotValidBecause("correlation id cannot be null");
							////////// --- FLOW DATA
							if (ctx.getFlowDirection() == null) return ObjectValidationResultBuilder.on(ctx)
																							 	    .isNotValidBecause("flow direction cannot be null");
							if (ctx.getOriginPartyId() == null) return ObjectValidationResultBuilder.on(ctx)
																							 		.isNotValidBecause("origin party cannot be null");
							if (ctx.getDestinationPartyId() == null) return ObjectValidationResultBuilder.on(ctx)
																								  	     .isNotValidBecause("destination party cannot be null");
							// valid
							return ObjectValidationResultBuilder.on(ctx)
															    .isValid();
						}
					};
	}
}
