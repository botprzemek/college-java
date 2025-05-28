package pl.wsti.edu.no_6;

import java.util.Vector;

public class MessageQueue {
    Vector<Object> queue = new Vector<>();

    public Vector<Object> get() {
        return queue;
    }

    public synchronized void send(Object element) {
        queue.addElement(element);
    }

    public synchronized Object recieve() {
        if (queue.isEmpty()) {
            return null;
        }

        Object element = queue.firstElement();
        queue.removeElementAt(0);

        return element;
    }
}