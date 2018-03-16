package doo.gl.user.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.time.ZonedDateTime;
import java.util.Date;

@Converter(autoApply = true)
public class DateToZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Date> {
    @Override
    public Date convertToDatabaseColumn(ZonedDateTime attribute) {
        return attribute != null ? Date.from(attribute.toInstant()) : null;
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Date dbData) {
        return dbData != null ? ZonedDateTime.ofInstant(dbData.toInstant(), DateUtils.DEFAULT_ZONE_ID) : null;
    }
}

