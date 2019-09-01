package discrimy.alrothims;

import discrimy.algorithms.datastruct.Map;
import discrimy.algorithms.datastruct.impl.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadHashCodeHashMapTest {
    private Map<BadHashCodeInteger, String> badHashCodeMap;

    @BeforeEach
    void setUp() {
        badHashCodeMap = new HashMap<>();
        badHashCodeMap.put(new BadHashCodeInteger(1), "1");
        badHashCodeMap.put(new BadHashCodeInteger(2), "2");
        badHashCodeMap.put(new BadHashCodeInteger(3), "3");
        badHashCodeMap.put(new BadHashCodeInteger(4), "4");
        badHashCodeMap.put(new BadHashCodeInteger(5), "5");
        badHashCodeMap.put(new BadHashCodeInteger(6), "6");
        badHashCodeMap.put(new BadHashCodeInteger(7), "7");
    }

    @Test
    void size() {
        assertEquals(7, badHashCodeMap.size());
    }

    @Test
    void put() {
        badHashCodeMap.put(new BadHashCodeInteger(10), "10");
        assertEquals(8, badHashCodeMap.size());
        badHashCodeMap.put(new BadHashCodeInteger(1), "11");
        assertEquals(8, badHashCodeMap.size());
        assertEquals(Optional.of("11"), badHashCodeMap.get(new BadHashCodeInteger(1)));
    }

    @Test
    void get() {
        assertEquals(Optional.of("1"), badHashCodeMap.get(new BadHashCodeInteger(1)));
        assertEquals(Optional.of("2"), badHashCodeMap.get(new BadHashCodeInteger(2)));
        assertEquals(Optional.of("4"), badHashCodeMap.get(new BadHashCodeInteger(4)));
        assertEquals(Optional.of("7"), badHashCodeMap.get(new BadHashCodeInteger(7)));
    }

    @Test
    void remove() {
        badHashCodeMap.remove(new BadHashCodeInteger(1));
        badHashCodeMap.remove(new BadHashCodeInteger(2));
        badHashCodeMap.remove(new BadHashCodeInteger(7));
        assertEquals(4, badHashCodeMap.size());
        assertEquals(Optional.empty(), badHashCodeMap.get(new BadHashCodeInteger(1)));
        assertEquals(Optional.of("5"), badHashCodeMap.get(new BadHashCodeInteger(5)));
    }

    static class BadHashCodeInteger {
        private Integer integer;

        BadHashCodeInteger(Integer integer) {
            this.integer = integer;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(obj, integer);
        }
    }
}
