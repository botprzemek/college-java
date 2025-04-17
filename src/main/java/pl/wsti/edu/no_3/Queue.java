package pl.wsti.edu.no_3;

import java.util.Arrays;

public class Queue {
    private static final int N = 5;
    private final Object[] data;
    private int head;
    private int tail;
    private int length;

    public Queue() {
        data = new Object[N];

        head = 0;
        length = 0;
    }

    public int getSize() {
        return N;
    }

    public int getLength() {
        return length;
    }

    public Queue add(Object element) throws QueueOverloadedException {
        if (length == N) {
            throw new QueueOverloadedException("Queue overload while adding " + length + "-th element: " + element.toString());
        }

        data[tail] = element;
        tail = (tail + 1) % N;
        length++;

        return this;
    }

    public Object get() throws QueueEmptyException {
        if (length == 0) {
            throw new QueueEmptyException("Queue is empty");
        }

        Object element = data[head];
        head = (head + 1) % N;
        length--;

        return element;
    }
}