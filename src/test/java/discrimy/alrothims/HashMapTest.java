package discrimy.alrothims;

import discrimy.algorithms.datastruct.Map;
import discrimy.algorithms.datastruct.impl.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {
    private Map<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
    }

    @Test
    void size() {
        assertEquals(7, map.size());
    }

    @Test
    void put() {
        map.put(10, "10");
        assertEquals(8, map.size());
        map.put(1, "11");
        assertEquals(8, map.size());
        assertEquals(Optional.of("11"), map.get(1));
    }

    @Test
    void get() {
        Optional<String> value = map.get(7);
        assertEquals(Optional.of("7"), value);
        Optional<String> empty = map.get(-1);
        assertEquals(Optional.empty(), empty);
    }

    @Test
    void remove() {
        map.remove(7);
        assertEquals(6, map.size());
        map.remove(-1);
        assertEquals(6, map.size());
    }

    @Test
    void hashMapOverflow() {
        map.put(10, "10");
        map.put(11, "11");
        map.put(12, "12");
        map.put(13, "13");
        map.put(14, "14");
        map.put(15, "15");
        map.put(16, "16");
        map.put(17, "17");
        map.put(18, "18");
        map.put(19, "19");
        map.put(20, "20");
        map.put(21, "21");
        map.put(22, "22");

        assertEquals(20, map.size());
    }

    @Test
    void badHashCode() {
        Map<BadHashCodeInteger, String> badHashCodeMap = new HashMap<>();
        badHashCodeMap.put(new BadHashCodeInteger(1), "1");
        badHashCodeMap.put(new BadHashCodeInteger(2), "2");
        badHashCodeMap.put(new BadHashCodeInteger(3), "3");
        badHashCodeMap.put(new BadHashCodeInteger(4), "4");
        badHashCodeMap.put(new BadHashCodeInteger(5), "5");
        badHashCodeMap.put(new BadHashCodeInteger(6), "6");
        badHashCodeMap.put(new BadHashCodeInteger(7), "7");

        assertEquals(7, badHashCodeMap.size());
        assertEquals(Optional.of("1"), badHashCodeMap.get(new BadHashCodeInteger(1)));
        assertEquals(Optional.of("2"), badHashCodeMap.get(new BadHashCodeInteger(2)));
        assertEquals(Optional.of("4"), badHashCodeMap.get(new BadHashCodeInteger(4)));
        assertEquals(Optional.of("7"), badHashCodeMap.get(new BadHashCodeInteger(7)));

        badHashCodeMap.remove(new BadHashCodeInteger(1));
        badHashCodeMap.remove(new BadHashCodeInteger(2));
        badHashCodeMap.remove(new BadHashCodeInteger(7));
        assertEquals(4, badHashCodeMap.size());
        assertEquals(Optional.empty(), badHashCodeMap.get(new BadHashCodeInteger(1)));
        assertEquals(Optional.of("5"), badHashCodeMap.get(new BadHashCodeInteger(5)));
    }

    class BadHashCodeInteger {
        private Integer integer;

        public BadHashCodeInteger(Integer integer) {
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