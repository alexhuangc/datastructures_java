import datastructures.arrays.DynamicArray;
import datastructures.graphs.UnionFind;

public class Tests {
    public static void main(String[] args) {
        UnionFind<Integer> uf = new UnionFind<>();
        // System.out.println("test");
        for (int i = 0; i < 10; i++) {
            uf.add(i);
        }
        uf.union(3,2);
        uf.union(5,2);
        uf.union(1,2);
        System.out.println(uf.find(3) == uf.find(1));

    }
}
