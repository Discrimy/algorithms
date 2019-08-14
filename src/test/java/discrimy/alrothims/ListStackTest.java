package discrimy.alrothims;

import discrimy.algorithms.datastruct.ArrayList;
import discrimy.algorithms.datastruct.ListStack;
import discrimy.algorithms.datastruct.Stack;
import discrimy.algorithms.datastruct.StackEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListStackTest {
    private Stack<Integer> stack;

    @BeforeEach
    public void prepareStack() {
        stack = new ListStack<>(new ArrayList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void pop() {
        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void peek() {
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.peek());
        stack.pop();
        stack.pop();
        assertEquals(Integer.valueOf(1), stack.peek());
    }

    @Test
    public void throwEmpty() {
        stack.pop();
        stack.pop();
        stack.pop();
        assertThrows(StackEmptyException.class, () -> stack.pop());
    }

    @Test
    public void offset() {
        assertEquals(Optional.of(2), stack.offset(1));
        assertEquals(Optional.of(1), stack.offset(2));
        assertEquals(Optional.of(0), stack.offset(3));
        assertEquals(Optional.empty(), stack.offset(0));

        stack.pop();
        assertEquals(Optional.of(0), stack.offset(2));
    }
}
