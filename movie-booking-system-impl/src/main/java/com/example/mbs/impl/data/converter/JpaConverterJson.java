package com.example.mbs.impl.data.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Convert(converter = JpaConverterJson.class)
public class JpaConverterJson implements AttributeConverter<Map<String, List<Integer>>, Json> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, List<Integer>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public Map<String, List<Integer>> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, List<Integer>>>(){});
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
