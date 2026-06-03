package dena.api.common.model.interop.response;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import r01f.enums.EnumExtended;
import r01f.util.types.collections.CollectionUtils;

@Accessors(prefix = "_")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DN00InteropResponseStatus
 implements EnumExtended<DN00InteropResponseStatus> {
    OK("Message processed OK"),
    CLIENT_ERR("Client error"),
    SERVER_ERR("Server error"),
    QUEUED("The message has been queued for asynchronous processing");

/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
    @Getter private final String _description;
/////////////////////////////////////////////////////////////////////////////////////////
//  METHODS
/////////////////////////////////////////////////////////////////////////////////////////
    public static DN00InteropResponseStatus fromName(final String name) {
        return EnumExtended.fromName(name,DN00InteropResponseStatus.class)
                .orElseThrow(() -> new IllegalArgumentException("no " + DN00InteropResponseStatus.class + " element with name=" + name));
    }
    public static DN00InteropResponseStatus fromNameOrNull(final String name) {
        return EnumExtended.fromName(name,DN00InteropResponseStatus.class)
                .orElse(null);
    }
    public static Set<DN00InteropResponseStatus> fromNames(final String... names) {
        if (CollectionUtils.isNullOrEmpty(names)) return null;
        return Stream.of(names)
                .map(name -> DN00InteropResponseStatus.fromNameOrNull(name))
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableSet());
    }
    public static Set<DN00InteropResponseStatus> asSet() {
        return EnumSet.allOf(DN00InteropResponseStatus.class);
    }
}
