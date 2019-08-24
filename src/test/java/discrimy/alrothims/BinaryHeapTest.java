package discrimy.alrothims;

import discrimy.algorithms.datastruct.BinaryHeap;
import discrimy.algorithms.datastruct.impl.ArrayBinaryHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryHeapTest {
    private BinaryHeap<Integer> binaryHeap;

    @BeforeEach
    void setUp() {
        binaryHeap = ArrayBinaryHeap
                .fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8,});
    }

    @Test
    public void size() {
        assertEquals(8, binaryHeap.size());
    }

    @Test
    public void peek() {
        assertEquals(Integer.valueOf(8), binaryHeap.peek());
    }

    @Test
    public void pop() {
        assertEquals(Integer.valueOf(8), binaryHeap.pop());
        assertEquals(Integer.valueOf(7), binaryHeap.pop());
        assertEquals(Integer.valueOf(6), binaryHeap.pop());
        assertEquals(Integer.valueOf(5), binaryHeap.pop());
        assertEquals(Integer.valueOf(4), binaryHeap.pop());
        assertEquals(Integer.valueOf(3), binaryHeap.pop());
        assertEquals(Integer.valueOf(2), binaryHeap.pop());
        assertEquals(Integer.valueOf(1), binaryHeap.pop());
        assertEquals(0, binaryHeap.size());
    }

    @Test
    public void contains() {
        assertTrue(binaryHeap.contains(8));
        assertTrue(binaryHeap.contains(7));
        assertTrue(binaryHeap.contains(6));
        assertTrue(binaryHeap.contains(5));
        assertTrue(binaryHeap.contains(4));
        assertTrue(binaryHeap.contains(3));
        assertTrue(binaryHeap.contains(2));
        assertTrue(binaryHeap.contains(1));
        assertFalse(binaryHeap.contains(-1));
    }
}
