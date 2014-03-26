package net.hamnaberg.jsonstat.generator.model;

import java.util.LinkedList;
import java.util.List;

public class Dataset {

    private List value; // todo: support of object notation for values (sparse cube)
    private Dimension dimension;


    public Dataset() {
        this(null);
    }

    public Dataset(Dimension dimension) {
        this(dimension, new LinkedList());
    }

    public Dataset(Dimension dimension, List value) {
        this.value = value;
        this.dimension = dimension;
    }


    public List getValue() {
        return value;
    }

    public void setValue(List value) {
        this.value = value;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    //todo: add properties: status, label, updated, source

}
