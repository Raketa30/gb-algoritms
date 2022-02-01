package ru.training.geekbrains.hw4;

public class PriorityQueueIm<E extends Comparable<? super E>> implements IQueue<E>{

    private final Object[] baseArray;
    private int size;

    public PriorityQueueIm() {
        baseArray = new Object[10];
        size = 0;
    }

    @Override
    public boolean offer(E value) {
        return false;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return (E) baseArray[0];
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(baseArray[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
