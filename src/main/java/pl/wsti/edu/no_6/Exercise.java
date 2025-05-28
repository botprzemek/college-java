package pl.wsti.edu.no_6;

public class Exercise {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();

        Threaaad tread1 = new Threaaad(queue, 1);
        Threaaad tread2 = new Threaaad(queue, 2);

        tread1.start();
        tread2.start();

        try {
            tread1.join();
            tread2.join();
        }
        catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        Object element = queue.recieve();

        while (queue.get() != null) {
            if (element instanceof Integer) {
                System.out.println(element);
            }

            queue.recieve();
        }
    }
}