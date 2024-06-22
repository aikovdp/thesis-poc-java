package me.aikovdp.jormungandr.workflows;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WorkflowOutput {
    private final Map<String, Object> output = new HashMap<>();

    public <T> void put(OutputKey<T> key, T value) {
        output.put(key.path(), value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(OutputKey<T> key) {
        return (T) output.get(key.path());
    }

    @SuppressWarnings("unchecked")
    public <T> T computeIfAbsent(OutputKey<T> key, Function<String, ? extends T> mappingFunction) {
        return (T) output.computeIfAbsent(key.path(), mappingFunction);
    }
}
