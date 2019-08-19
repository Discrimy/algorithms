package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.Stack;
import discrimy.algorithms.datastruct.StackEmptyException;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedListStack<T> implements Stack<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();

    public LinkedListStack() {
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public T peek() {
        try {
            return linkedList.getLast();
        } catch (NoSuchElementException e) {
            throw new StackEmptyException("Stack has no elements", e);
        }
    }

    @Override
    public T pop() {
        try {
            T value = linkedList.getLast();
            linkedList.removeLast();
            return value;
        } catch (NoSuchElementException e) {
            throw new StackEmptyException("Stack has no elements", e);
        }
    }

    @Override
    public void push(T value) {
        linkedList.addLast(value);
    }

    @Override
    public Optional<Integer> offset(T value) {
        Optional<Integer> lastIndex = linkedList.lastIndexOf(value);
        return lastIndex.map(index -> linkedList.size() - index - 1);
    }
}
