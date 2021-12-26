package ru.training.geekbrains.hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIm<E> implements IList<E>, IDeque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListIm() {
        size = 0;
    }

    @Override
    public boolean add(E value) {
        linkLast(value);
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        checkIndex(index);
        if (index == size) {
            linkLast(value);
        } else {
            linkBefore(value, node(index));
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = head;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E element() {
        return peek();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public boolean offerFirst(E e) {
        linkHead(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E peek() {
        final Node<E> headNode = head;
        return headNode == null ? null : headNode.item;
    }

    @Override
    public E peekFirst() {
        return peek();
    }

    @Override
    public E peekLast() {
        final Node<E> tailNode = head;
        return tailNode == null ? null : tailNode.item;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = head;
        while (current != null) {
            if (current.item.equals(value)) {
                unlinkNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        if (index == size) {
            unlinkTail();
        } else {
            unlinkNode(node(index));
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            while (current != null) {
                sb.append(current.item.toString());
                if (current.next != null) {
                    sb.append(", ");
                }
                current = current.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void linkBefore(E e, Node<E> bef) {
        final Node<E> prev = bef.prev;
        final Node<E> newNode = new Node<>(prev, e, bef);
        bef.prev = newNode;

        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private void linkHead(E e) {
        if (head == null) {
            linkLast(e);
        } else {
            linkBefore(e, head);
        }
    }

    private void linkLast(E value) {
        final Node<E> last = tail;
        final Node<E> newNode = new Node<>(last, value, null);
        tail = newNode;

        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    private Node<E> node(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private E removeFirst() {
        final Node<E> first = head;
        if (first == null) {
            throw new NoSuchElementException();
        }

        return unlinkHead(first);
    }

    private E removeLast() {
        final Node<E> last = tail;
        if (last == null) {
            throw new NoSuchElementException();
        }
        return unlinkTail();
    }

    private E unlinkHead(Node<E> first) {
        final E element = first.item;
        final Node<E> next = head.next;
        head.next = null;
        head.item = null;

        head = next;

        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    private void unlinkNode(Node<E> node) {
        final E element = node.item;
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size--;
    }

    private E unlinkTail() {
        final Node<E> newTail = tail.prev;
        final E element = tail.item;

        tail.prev = null;
        tail.item = null;

        tail = newTail;

        if (newTail == null) {
            head = null;
        } else {
            newTail.next = null;
        }
        size--;
        return element;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
