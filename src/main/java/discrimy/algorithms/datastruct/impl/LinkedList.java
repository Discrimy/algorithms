package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.List;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        linkFirst(node);
        size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        linkLast(node);
        size++;
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("Linked list is empty");
        }

        return first.getData();
    }

    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException("Linked list is empty");
        }

        return last.getData();
    }

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("Linked list is empty");
        }

        unlink(first);
        size--;
    }

    public void removeLast() {
        if (last == null) {
            throw new NoSuchElementException("Linked list is empty");
        }

        unlink(last);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        Node<T> node = new Node<>(data);
        linkLast(node);
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    @Override
    public void remove(int index) {
        Node<T> node = getNode(index);
        unlink(node);
        size--;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.getData(), o)) {
                unlink(node);
                size--;
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.getData(), o)) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    @Override
    public Optional<Integer> indexOf(Object o) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.getData(), o)) {
                return Optional.of(i);
            }
            node = node.getNext();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> lastIndexOf(Object o) {
        Node<T> node = last;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(node.getData(), o)) {
                return Optional.of(i);
            }
            node = node.getPrevious();
        }

        return Optional.empty();
    }

    private void link(@NotNull Node<T> next, @NotNull Node<T> prev) {
        next.setPrevious(prev);
        prev.setNext(next);
    }

    private void linkLast(Node<T> node) {
        if (first == null) {
            first = node;
        } else {
            link(node, last);
        }

        last = node;
    }

    private void linkFirst(Node<T> node) {
        if (first != null) {
            link(first, node);
        } else {
            last = node;
        }

        first = node;
    }

    private void unlink(Node<T> node) {
        if (node != first && node != last) {
            link(node.getNext(), node.getPrevious());
        } else if (node == first && node == last) {
            first = null;
            last = null;
        } else {
            if (node == first) {
                node.getNext().setPrevious(null);
                first = node.getNext();
            }

            if (node == last) {
                node.getPrevious().setNext(null);
                last = node.getPrevious();
            }
        }

        node.setNext(null);
        node.setPrevious(null);
    }

    private Node<T> getNode(int index) {
        requireIndexInBound(index);
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    private void requireIndexInBound(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Size is " + size + " but index is " + index);
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }
}
