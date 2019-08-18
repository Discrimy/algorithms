package discrimy.alrothims;

import discrimy.algorithms.datastruct.Queue;
import discrimy.algorithms.datastruct.impl.LinkedListQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListQueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void prepare() {
        queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test
    public void size() {
        assertEquals(3, queue.size());
    }

    @Test
    public void contains() {
        assertTrue(queue.contains(1));
        assertTrue(queue.contains(2));
        assertTrue(queue.contains(3));
        assertFalse(queue.contains(-1));
    }

    @Test
    public void enqueue() {
        queue.enqueue(4);
        assertEquals(4, queue.size());
    }

    @Test
    public void dequeue() {
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(0, queue.size());
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}
