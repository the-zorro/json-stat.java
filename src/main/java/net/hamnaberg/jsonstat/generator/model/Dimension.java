package net.hamnaberg.jsonstat.generator.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.hamnaberg.jsonstat.generator.serializer.JacksonDimensionSerializer;

import java.util.LinkedList;
import java.util.List;


@JsonSerialize(using = JacksonDimensionSerializer.class)
public class Dimension {

    private String id;
    private List<String> category;


    public Dimension(String id) {
        this(id, new LinkedList<String>());
    }

    public Dimension(String id, List<String> category) {
        this.id = id;
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Dimension addCategory(String category) {
        this.category.add(category);
        return this;
    }

    // todo: add all the complex properties, for now it's for very limited and trivial
//       case of one dimension with fixed number of categories

}
