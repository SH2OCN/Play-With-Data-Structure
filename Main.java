package bobo;

public class Main {

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(3);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 10; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
