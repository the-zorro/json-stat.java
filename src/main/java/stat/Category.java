package stat;



import net.hamnaberg.funclite.Optional;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Category {
    private final Map<String, String> labels = new LinkedHashMap<>();
    private final Map<String, Integer> indices = new LinkedHashMap<>();
    private final Map<String, List<String>> children = new LinkedHashMap<>();

    public Category(Map<String, Integer> indices, Map<String, String> labels, Map<String, List<String>> children) {
        this.indices.putAll(indices);
        this.labels.putAll(labels);
        this.children.putAll(children);
    }

    public int getIndex(String id) {
        Integer integer = indices.get(id);
        if (integer == null) {
            return 0;
        }
        return integer;
    }

    public Optional<String> getLabel(String id) {
        return Optional.fromNullable(labels.get(id));
    }

    public List<String> getChild(String id) {
        return children.containsKey(id) ? children.get(id) : Collections.<String>emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!children.equals(category.children)) return false;
        if (!indices.equals(category.indices)) return false;
        if (!labels.equals(category.labels)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labels.hashCode();
        result = 31 * result + indices.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }
}

