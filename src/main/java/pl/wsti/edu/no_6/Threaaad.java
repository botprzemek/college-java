package pl.wsti.edu.no_6;

public class Threaaad extends Thread {
    private final MessageQueue queue;
    private final int start;

    public Threaaad(MessageQueue queue, int start) {
        this.queue = queue;
        this.start = start;
    }

    public void run() {
        try {
            for (int i = start; i <= 10; i += 2) {
                queue.send(i);

                Thread.sleep(50);
            }
        }
        catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
