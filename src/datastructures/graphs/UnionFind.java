package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> {
    private final Map<T, Integer> objectToIndexMapping;
    private final ArrayList<T> indexToObjectMapping;
    private final ArrayList<Integer> connections;

    public UnionFind() {
        objectToIndexMapping = new HashMap<>();
        indexToObjectMapping = new ArrayList<>();
        connections = new ArrayList<>();
    }

    public void add(T object) {
        objectToIndexMapping.put(object, connections.size());
        indexToObjectMapping.add(object);
        connections.add(connections.size());
    }

    public T find(T object) {
        Integer currentIndex = objectToIndexMapping.get(object);
        if (currentIndex == null) {
            throw new IllegalArgumentException("Object not found in UnionFind.");
        }

        while (!currentIndex.equals(connections.get(currentIndex))) {
            currentIndex = connections.get(currentIndex);
        }
        return indexToObjectMapping.get(currentIndex);
    }

    public void union(T object1, T object2) {
        Integer object1RootIndex = objectToIndexMapping.get(find(object1));
        Integer object2RootIndex = objectToIndexMapping.get(find(object2));

        if (object1RootIndex == null || object2RootIndex == null) {
            throw new IllegalArgumentException("Either object1 or object2 or both are not found in UnionFind.");
        }

        // Connect object2 to object1
        connections.set(object2RootIndex, object1RootIndex);
    }
}
