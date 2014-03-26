package net.hamnaberg.jsonstat.generator.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;


public class JSONStat {

    private Map<String, Dataset> datasets;

    public JSONStat() {
        datasets = new HashMap<>(1);
    }

    public JSONStat(Dataset dataset) {
        this();
        datasets.put("dataset", dataset);
    }


    @JsonAnyGetter
    public Map<String, Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(Map<String, Dataset> datasets) {
        this.datasets = datasets;
    }

    @JsonAnySetter
    public void addDataset(String name, Dataset datqaset) {
        datasets.put(name, datqaset);
    }

    public Dataset removeDataset(String name) {
        return datasets.remove(name);
    }

}
