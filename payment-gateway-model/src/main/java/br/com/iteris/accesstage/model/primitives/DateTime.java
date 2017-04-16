package br.com.iteris.accesstage.model.primitives;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class DateTime {

    @JsonUnwrapped
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    public DateTime() {
        date = LocalDateTime.now();
    }

    public DateTime(LocalDateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
    }

    public DateTime(String dateStr) {
        TemporalAccessor accessor = DateTimeFormatter.ISO_DATE_TIME.parse(dateStr);
        this.date = LocalDateTime.from(accessor);
    }

    @Override
    @JsonValue
    public String toString() {
        return date.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}