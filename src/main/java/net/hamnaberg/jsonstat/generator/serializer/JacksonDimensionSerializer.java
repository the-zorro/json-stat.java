package net.hamnaberg.jsonstat.generator.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.hamnaberg.jsonstat.generator.model.Dimension;

import java.io.IOException;

public class JacksonDimensionSerializer extends JsonSerializer<Dimension> {

    @Override
    public void serialize(Dimension dimension, JsonGenerator generator,
                          SerializerProvider serializerProvider) throws IOException {
        generator.writeStartObject();
        // id attribute
        generator.writeArrayFieldStart("id");
        generator.writeString(dimension.getId());
        generator.writeEndArray();
        // size attribute
        generator.writeArrayFieldStart("size");
        generator.writeNumber(dimension.getCategory().size());
        generator.writeEndArray();
        // categories portion
        generator.writeObjectFieldStart(dimension.getId());
        generator.writeObjectFieldStart("category");
        generator.writeObjectFieldStart("index");
        int index = 0;
        for(String category : dimension.getCategory()) {
            generator.writeNumberField(category, index++);
        }
        generator.writeEndObject();
        generator.writeEndObject();
        generator.writeEndObject();
        generator.writeEndObject();
    }

}
