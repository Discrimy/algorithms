package discrimy.algorithms.datastruct;

import java.util.Optional;

public class ListStack<T> implements Stack<T> {
    private List<T> list;

    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public T pop() {
        try {
            T value = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return value;
        } catch (IndexOutOfBoundsException e) {
            throw new StackEmptyException("Stack has no elements", e);
        }
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public Optional<Integer> offset(T value) {
        Optional<Integer> offset = list.indexOf(value);
        return offset.map(index -> list.size() - index - 1);
    }
}
