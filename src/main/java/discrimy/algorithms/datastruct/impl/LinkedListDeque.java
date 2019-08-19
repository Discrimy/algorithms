package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.Deque;
import discrimy.algorithms.datastruct.DequeEmptyException;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedListDeque<T> implements Deque<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public void pushFirst(T value) {
        linkedList.addFirst(value);
    }

    @Override
    public void pushLast(T value) {
        linkedList.addLast(value);
    }

    @Override
    public T popFirst() {
        try {
            T value = linkedList.getFirst();
            linkedList.removeFirst();
            return value;
        } catch (NoSuchElementException e) {
            throw new DequeEmptyException("Deque has no elements", e);
        }
    }

    @Override
    public T popLast() {
        try {
            T value = linkedList.getLast();
            linkedList.removeLast();
            return value;
        } catch (NoSuchElementException e) {
            throw new DequeEmptyException("Deque has no elements", e);
        }
    }

    @Override
    public T peekFirst() {
        try {
            return linkedList.getFirst();
        } catch (NoSuchElementException e) {
            throw new DequeEmptyException("Deque has no elements", e);
        }
    }

    @Override
    public T peekLast() {
        try {
            return linkedList.getLast();
        } catch (NoSuchElementException e) {
            throw new DequeEmptyException("Deque has no elements", e);
        }
    }

    @Override
    public boolean contains(Object object) {
        return linkedList.contains(object);
    }

    @Override
    public Optional<Integer> indexOf(Object object) {
        return linkedList.indexOf(object);
    }

    @Override
    public Optional<Integer> lastIndexOf(Object object) {
        return linkedList.lastIndexOf(object);
    }
}
