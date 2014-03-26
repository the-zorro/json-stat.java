package net.hamnaberg.jsonstat.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.hamnaberg.jsonstat.generator.model.Dataset;
import net.hamnaberg.jsonstat.generator.model.Dimension;
import net.hamnaberg.jsonstat.generator.model.JSONStat;

import java.util.Arrays;


public class GeneratorMain {

    public static void main(String[] args) throws JsonProcessingException {
        Dimension dim = new Dimension("metric");
        dim.addCategory("totalPages").addCategory("totalVisits").addCategory("avgPpV");

        Dataset set = new Dataset(dim, Arrays.asList(1, 2, 0.5));

        JSONStat stat = new JSONStat(set);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        System.out.println(mapper.writeValueAsString(stat));
    }

}
