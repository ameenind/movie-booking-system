package com.example.mbs.impl.data.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

@Convert(converter = JpaConverterJson.class)
public class JpaConverterJson implements AttributeConverter<Map<String, List<Integer>>, JsonObject> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public JsonObject convertToDatabaseColumn(Map<String, List<Integer>> attribute) {
        try {
            JsonObject object =
                    Json.createReader(new StringReader(objectMapper.writeValueAsString(attribute))).readObject();
            return object;
            //return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public Map<String, List<Integer>> convertToEntityAttribute(JsonObject object) {
        try {
            String content = object.toString();
            return objectMapper.readValue(content, new TypeReference<Map<String, List<Integer>>>() {
            });
            //return objectMapper.readValue(object, new TypeReference<Map<String, List<Integer>>>(){});
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
