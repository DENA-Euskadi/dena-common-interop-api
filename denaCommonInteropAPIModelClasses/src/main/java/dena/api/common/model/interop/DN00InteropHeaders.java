package dena.api.common.model.interop;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class DN00InteropHeaders {
//////////////////////////////////////////////////////////////////////////////
//	CONSTANTS
//////////////////////////////////////////////////////////////////////////////
    public static final String HEADER_THIS_TIMESTAMP = "X-DENA-This-TimeStamp";
    public static final String HEADER_ORIGIN_TIMESTAMP = "X-DENA-Origin-TimeStamp";
    public static final String HEADER_CORRELATION_ID = "X-DENA-Message-Correlation-Id";
    public static final String HEADER_DENA_DATA_DIGEST = "X-DENA-Data-Digest";
    public static final String HEADER_CONTENT_DIGEST = "Content-Digest";
    public static final String ALGORITHM_DENA_DIGEST = "SHA-256";

}