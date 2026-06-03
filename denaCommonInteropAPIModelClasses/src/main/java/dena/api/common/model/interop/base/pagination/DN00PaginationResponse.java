package dena.api.common.model.interop.base.pagination;

import dena.api.common.model.interop.DN00IsInteropModelObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;

import java.io.Serial;

@Accessors(prefix="_")
@MarshallType(as="paginationResponse")
public class DN00PaginationResponse
        implements DN00IsInteropModelObject {

    @Serial
    private static final long serialVersionUID = -7989191651058921856L;

//////////////////////////////////////////////////////////////////////////////
//       FIELDS
//////////////////////////////////////////////////////////////////////////////

    /*
     *  Total of items matching the search criteria
     * */
    @MarshallField(as="totalItemsCount",
            whenXml=@MarshallField.MarshallFieldAsXml(attr=true))
    @Getter @Setter  private int _totalItemsCount;

    /**
     * This results page initial row number
     */
    @MarshallField(as="startPosition",
            whenXml=@MarshallField.MarshallFieldAsXml(attr=true))
    @Getter @Setter private int _startPosition;

    /**
     * This results page final row number
     */
    @MarshallField(as="endPosition",
            whenXml=@MarshallField.MarshallFieldAsXml(attr=true))
    @Getter @Setter private int _endPosition;

    /**
     * The number of requested items (usually the page size)
     */
    @MarshallField(as="requestedNumberOfItems",
            whenXml=@MarshallField.MarshallFieldAsXml(attr=true))
    @Getter @Setter private int _requestedNumberOfItems;
}
