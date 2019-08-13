package discrimy.alrothims;

import discrimy.algorithms.datastruct.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    LinkedList<Integer> linkedList;

    @BeforeEach
    public void prepare() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(3);
    }

    @Test
    public void throwIndexOutOfBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(3));
    }

    @Test
    public void get() {
        assertEquals(linkedList.size(), 3);
        assertEquals(linkedList.get(0), Integer.valueOf(1));
        assertEquals(linkedList.get(1), Integer.valueOf(5));
        assertEquals(linkedList.get(2), Integer.valueOf(3));
    }

    @Test
    public void removeIndex() {
        linkedList.remove(1);

        assertEquals(linkedList.size(), 2);
        assertEquals(linkedList.get(0), Integer.valueOf(1));
        assertEquals(linkedList.get(1), Integer.valueOf(3));
    }

    @Test
    public void removeValue() {
        boolean isRemoved = linkedList.remove(Integer.valueOf(5));

        assertTrue(isRemoved);
        assertEquals(linkedList.size(), 2);
        assertEquals(linkedList.get(0), Integer.valueOf(1));
        assertEquals(linkedList.get(1), Integer.valueOf(3));
    }

    @Test
    public void contains() {
        boolean containsTrue = linkedList.contains(5);
        boolean containsFalse = linkedList.contains(-1);

        assertTrue(containsTrue);
        assertFalse(containsFalse);
    }

    @Test
    public void indexOf() {
        Optional<Integer> index = linkedList.indexOf(5);
        Optional<Integer> lastIndex = linkedList.lastIndexOf(1);
        Optional<Integer> noIndex = linkedList.indexOf(-1);
        Optional<Integer> noLastIndex = linkedList.lastIndexOf(-1);

        assertEquals(Optional.of(1), index);
        assertEquals(Optional.of(0), lastIndex);
        assertEquals(Optional.empty(), noIndex);
        assertEquals(Optional.empty(), noLastIndex);
    }
}
