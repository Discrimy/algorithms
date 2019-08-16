package discrimy.alrothims;

import discrimy.algorithms.datastruct.List;
import discrimy.algorithms.datastruct.impl.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    List<Integer> list;

    @BeforeEach
    public void prepare() {
        list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
    }

    @Test
    public void throwIndexOutOfBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    public void get() {
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(5), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void removeIndex() {
        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void removeValue() {
        boolean isRemoved = list.remove(Integer.valueOf(5));

        assertTrue(isRemoved);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void contains() {
        boolean containsTrue = list.contains(5);
        boolean containsFalse = list.contains(-1);

        assertTrue(containsTrue);
        assertFalse(containsFalse);
    }

    @Test
    public void indexOf() {
        Optional<Integer> index = list.indexOf(5);
        Optional<Integer> lastIndex = list.lastIndexOf(1);
        Optional<Integer> noIndex = list.indexOf(-1);
        Optional<Integer> noLastIndex = list.lastIndexOf(-1);

        assertEquals(Optional.of(1), index);
        assertEquals(Optional.of(0), lastIndex);
        assertEquals(Optional.empty(), noIndex);
        assertEquals(Optional.empty(), noLastIndex);
    }
}
