package me.aikovdp.jormungandr.workflows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attributes {
    private final Map<String, Map<String, List<String>>> attributes = new HashMap<>();

    public void setAttribute(String category, String name, List<String> values) {
        attributes.computeIfAbsent(category, (key) -> new HashMap<>())
                .put(name, values);
    }

    public List<String> getAttribute(String category, String name) {
        Map<String, List<String>> categoryMap = attributes.get(category);
        if (categoryMap == null) return null;
        return categoryMap.get(name);
    }
}
