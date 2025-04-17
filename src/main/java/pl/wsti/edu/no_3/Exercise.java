package pl.wsti.edu.no_3;

public class Exercise {
    public static void main(String[] args) {
        Expression expression = new Expression("(9/4)*3");
        Queue queue = new Queue();

        try {
            System.out.println(expression.calculate());

            queue
                .add(7)
                .add("Ala ma kota")
                .add(3.14)
                .add(7)
                .add("Ala ma kota");

            while (queue.getLength() >= 0) {
                System.out.println(queue.get().toString());
            }
        }
        catch (QueueOverloadedException | QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}