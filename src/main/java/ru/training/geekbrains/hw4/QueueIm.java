package ru.training.geekbrains.hw4;

public class QueueIm<E> implements IQueue<E> {
    private final LinkedListIm<E> queueBase;

    public QueueIm() {
        this.queueBase = new LinkedListIm<>();
    }

    @Override
    public boolean offer(E value) {
        return queueBase.offer(value);
    }

    @Override
    public E element() {
        return queueBase.element();
    }

    @Override
    public E peek() {
        return queueBase.peek();
    }

    @Override
    public E poll() {
        return queueBase.poll();
    }

    @Override
    public boolean isEmpty() {
        return queueBase.isEmpty();
    }

    @Override
    public String toString() {
        return queueBase.toString();
    }
}
