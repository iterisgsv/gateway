package br.com.iteris.accesstage.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

import br.com.iteris.accesstage.model.ReturnCode;

@Converter
public class ReturnCodeConverter implements AttributeConverter<ReturnCode, String> {
    @Override
    public String convertToDatabaseColumn(ReturnCode attribute) {
        return Optional.ofNullable(attribute).map(ReturnCode::representation).orElse(null);
    }

    @Override
    public ReturnCode convertToEntityAttribute(String dbData) {
        return ReturnCode.fromRepresentation(dbData);
    }
}
