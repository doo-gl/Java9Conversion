package doo.gl.user.configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtils {

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");

    public static ZonedDateTime nowUTC() {
        return ZonedDateTime.now(DEFAULT_ZONE_ID);
    }

}
