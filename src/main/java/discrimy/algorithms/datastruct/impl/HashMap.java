package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.Map;

import java.util.Objects;
import java.util.Optional;

public class HashMap<K, V> implements Map<K, V> {
    private int size = 0;

    private Node<K, V>[] nodes;

    public HashMap() {
        nodes = new Node[16];
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseNodesSize() {
        Node<K, V>[] oldNodes = nodes;
        nodes = new Node[oldNodes.length * 2];

        size = 0;
        for (Node<K, V> node : oldNodes) {
            while (node != null) {
                put(node.getKey(), node.getValue());
                node = node.getNext();
            }
        }
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash & (nodes.length - 1);

        if (nodes[index] == null) {
            nodes[index] = new Node<>(hash, key, value);
            size++;
        } else {
            Node<K, V> node = nodes[index];
            boolean replaced = false;
            while (node != null && !replaced) {
                if (Objects.equals(node.getKey(), key)) {
                    node.setValue(value);
                    replaced = true;
                }

                if (node.getNext() == null && !replaced) {
                    node.setNext(new Node<>(hash, key, value));
                    break;
                }

                node = node.getNext();
            }

            if (!replaced) {
                size++;
            }
        }

        if (size * 2 >= nodes.length) {
            increaseNodesSize();
        }
    }

    @Override
    public Optional<V> get(K key) {
        int hash = key.hashCode();
        int index = hash & (nodes.length - 1);

        Node<K, V> node = nodes[index];
        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                return Optional.of(node.getValue());
            }

            node = node.getNext();
        }

        return Optional.empty();
    }

    @Override
    public void remove(K key) {
        int hash = key.hashCode();
        int index = hash & (nodes.length - 1);

        Node<K, V> node = nodes[index];
        if (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                nodes[index] = node.getNext();
                size--;
            } else {
                do {
                    Node<K, V> prev = node;
                    node = node.getNext();

                    if (Objects.equals(node.getKey(), key)) {
                        prev.setNext(node.getNext());
                        size--;
                        break;
                    }
                } while (node != null);
            }
        }
    }

    private class Node<KK, VV> {
        private int hash;
        private KK key;
        private VV value;
        private Node<KK, VV> next;

        public Node(int hash, KK key, VV value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public KK getKey() {
            return key;
        }

        public void setKey(KK key) {
            this.key = key;
        }

        public VV getValue() {
            return value;
        }

        public void setValue(VV value) {
            this.value = value;
        }

        public Node<KK, VV> getNext() {
            return next;
        }

        public void setNext(Node<KK, VV> next) {
            this.next = next;
        }
    }
}
