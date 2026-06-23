package dena.api.common.model.interop.base.pagination;

import dena.api.common.model.interop.DN00IsInteropModelObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;

import java.io.Serial;

@Accessors(prefix="_")
@MarshallType(as="paginationRequest")
public class DN00PaginationRequest 
        implements DN00IsInteropModelObject {

    @Serial
    private static final long serialVersionUID = -1427292324347699319L;
    /*
     *   Pagination parameter first item (page number), starting 0
     * */
    @MarshallField(as="firstItemNum")
    @Getter @Setter private int _firstItemNum;

    /*
     *   Pagination parameter numbers of items
     * */
    @MarshallField(as="numberOfItems")
    @Getter @Setter private int _numberOfItems;
}
