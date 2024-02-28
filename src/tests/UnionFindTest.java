import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import datastructures.graphs.UnionFind;

public class UnionFindTest {

    @Test
    public void testUnionFind() {
        // Create a UnionFind instance
        UnionFind<Integer> unionFind = new UnionFind<>();

        // Add elements to the UnionFind instance
        unionFind.add(1);
        unionFind.add(2);
        unionFind.add(3);
        unionFind.add(4);

        // Test find method
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        // Test union method
        unionFind.union(1, 2);
        assertEquals(1, unionFind.find(2)); // After union, the parent of 2 should be 1

        unionFind.union(3, 4);
        assertEquals(3, unionFind.find(4)); // After union, the parent of 4 should be 3

        unionFind.union(1, 4);
        assertEquals(1, unionFind.find(3)); // After further union, the parent of 4 (and hence 3) should be 1
    }
}
