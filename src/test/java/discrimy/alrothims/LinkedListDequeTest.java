package discrimy.alrothims;

import discrimy.algorithms.datastruct.DequeEmptyException;
import discrimy.algorithms.datastruct.impl.LinkedListDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDequeTest {
    private LinkedListDeque<Integer> linkedListDeque;

    @BeforeEach
    public void prepare() {
        linkedListDeque = new LinkedListDeque<>();
        linkedListDeque.pushFirst(1);
        linkedListDeque.pushFirst(2);
        linkedListDeque.pushFirst(3);
    }

    @Test
    public void size() {
        assertEquals(3, linkedListDeque.size());
    }

    @Test
    public void popFirst() {
        assertEquals(Integer.valueOf(3), linkedListDeque.popFirst());
        assertEquals(Integer.valueOf(2), linkedListDeque.popFirst());
        assertEquals(Integer.valueOf(1), linkedListDeque.popFirst());
        assertEquals(0, linkedListDeque.size());
        assertThrows(DequeEmptyException.class, () -> linkedListDeque.popFirst());
    }

    @Test
    public void popLast() {
        assertEquals(Integer.valueOf(1), linkedListDeque.popLast());
        assertEquals(Integer.valueOf(2), linkedListDeque.popLast());
        assertEquals(Integer.valueOf(3), linkedListDeque.popLast());
        assertEquals(0, linkedListDeque.size());
        assertThrows(DequeEmptyException.class, () -> linkedListDeque.popLast());
    }

    @Test
    public void peekFirst() {
        assertEquals(Integer.valueOf(3), linkedListDeque.peekFirst());
        linkedListDeque.popFirst();
        assertEquals(Integer.valueOf(2), linkedListDeque.peekFirst());
        linkedListDeque.popFirst();
        assertEquals(Integer.valueOf(1), linkedListDeque.peekFirst());
        linkedListDeque.popFirst();
        assertThrows(DequeEmptyException.class, () -> linkedListDeque.peekFirst());
    }

    @Test
    public void peekLast() {
        assertEquals(Integer.valueOf(1), linkedListDeque.peekLast());
        linkedListDeque.popLast();
        assertEquals(Integer.valueOf(2), linkedListDeque.peekLast());
        linkedListDeque.popLast();
        assertEquals(Integer.valueOf(3), linkedListDeque.peekLast());
        linkedListDeque.popLast();
        assertThrows(DequeEmptyException.class, () -> linkedListDeque.peekLast());
    }

    @Test
    public void pushFirst() {
        linkedListDeque.pushFirst(4);
        assertEquals(Integer.valueOf(4), linkedListDeque.popFirst());
    }

    @Test
    public void pushLast() {
        linkedListDeque.pushLast(0);
        assertEquals(Integer.valueOf(0), linkedListDeque.popLast());
    }

    @Test
    public void contains() {
        assertTrue(linkedListDeque.contains(1));
        assertTrue(linkedListDeque.contains(2));
        assertTrue(linkedListDeque.contains(3));
        assertFalse(linkedListDeque.contains(-1));
    }

    @Test
    public void indexOf() {
        assertEquals(Optional.of(0), linkedListDeque.indexOf(3));
        assertEquals(Optional.of(1), linkedListDeque.indexOf(2));
        assertEquals(Optional.of(2), linkedListDeque.indexOf(1));
        assertEquals(Optional.empty(), linkedListDeque.indexOf(-1));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(Optional.of(0), linkedListDeque.indexOf(3));
        assertEquals(Optional.of(1), linkedListDeque.indexOf(2));
        assertEquals(Optional.of(2), linkedListDeque.indexOf(1));
        assertEquals(Optional.empty(), linkedListDeque.indexOf(-1));
    }
}
