package ru.training.geekbrains.hw4;

import java.util.Iterator;
import java.util.Objects;

public class ArrayListIm<E> implements IList<E> {
    private static final double MULTIPLICATION_FACTOR = 1.61803398875;
    private Object[] objects;
    private int size;

    public ArrayListIm() {
        this.objects = new Object[10];
        this.size = 0;
    }

    @Override
    public boolean add(int index, E value) {
        checkIndex(index);
        objects[index] = value;
        return true;
    }

    @Override
    public boolean add(E value) {
        if (objects.length == size) {
            increaseSize();
        }
        objects[size] = value;
        size++;
        return false;
    }

    @Override
    public void clear() {
        this.objects = new Object[10];
    }

    @Override
    public boolean contains(E value) {
        for (Object object : objects) {
            if (Objects.nonNull(object) && object.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                return (E) objects[cursor++];
            }
        };
    }

    @Override
    public boolean remove(E value) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(value)) {
                fastRemove(objects, i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        fastRemove(objects, index);
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                sb.append(objects[i].toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
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

    private void fastRemove(Object[] destArr, int index) {
        final int newSize;
        if ((newSize = size - 1) > index) {
            System.arraycopy(destArr, index + 1, destArr, index, newSize - index);
        }
        destArr[size = newSize] = null;
    }

    private void increaseSize() {
        Object[] updatedArray = new Object[(int) (size * MULTIPLICATION_FACTOR)];
        System.arraycopy(this.objects, 0, updatedArray, 0, objects.length);
        this.objects = updatedArray;
    }
}
