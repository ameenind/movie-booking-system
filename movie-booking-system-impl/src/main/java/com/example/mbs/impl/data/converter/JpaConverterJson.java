package com.example.mbs.impl.data.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.Map;
import java.util.Set;

@Convert(converter = JpaConverterJson.class)
public class JpaConverterJson implements AttributeConverter<Map<String, Set<Integer>>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Set<Integer>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public Map<String, Set<Integer>> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, Set<Integer>>>(){});
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
