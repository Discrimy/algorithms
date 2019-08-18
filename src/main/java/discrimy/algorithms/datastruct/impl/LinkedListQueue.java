package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean contains(Object object) {
        return linkedList.contains(object);
    }

    @Override
    public void enqueue(T object) {
        linkedList.addFirst(object);
    }

    @Override
    public T dequeue() {
        T value = linkedList.getLast();
        linkedList.removeLast();
        return value;
    }
}
