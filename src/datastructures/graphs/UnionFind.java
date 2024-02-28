package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> {
    private final Map<T, Integer> objectToIndexMapping;
    private final ArrayList<T> indexToObjectMapping;
    private final ArrayList<Integer> connections;

    public UnionFind() {
        this.objectToIndexMapping = new HashMap<>();
        this.indexToObjectMapping = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    public void add(T object) {
        this.objectToIndexMapping.put(object, this.connections.size());
        this.indexToObjectMapping.add(object);
        this.connections.add(this.connections.size());
    }

    public T find(T object) {
        Integer currentIndex = this.objectToIndexMapping.get(object);
        if (currentIndex == null) {
            throw new IllegalArgumentException("Object not found in UnionFind.");
        }

        while (!currentIndex.equals(this.connections.get(currentIndex))) {
            currentIndex = this.connections.get(currentIndex);
        }
        return this.indexToObjectMapping.get(currentIndex);
    }

    public void union(T object1, T object2) {
        Integer object1RootIndex = this.objectToIndexMapping.get(find(object1));
        Integer object2RootIndex = this.objectToIndexMapping.get(find(object2));

        if (object1RootIndex == null || object2RootIndex == null) {
            throw new IllegalArgumentException("Either object1 or object2 or both are not found in UnionFind.");
        }

        // Connect object2 to object1
        this.connections.set(object2RootIndex, object1RootIndex);
    }
}
