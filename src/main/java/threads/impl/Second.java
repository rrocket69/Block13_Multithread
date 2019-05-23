package threads.impl;

import entities.Docs;
import threads.University;

import java.util.Queue;
import java.util.Random;

public class Second extends University {
    public Second(Queue<Docs> queue) {
        super(queue);
    }

    public void run() {
        Random rand = new Random();
        while (queue.peek() != null) {
            int cond = rand.nextInt(5);
            for (int i = 0; i < cond && queue.peek() != null; i++) {
                accepted.add(queue.poll());
            }
            sendSleep();
        }
        System.out.println("Second " + accepted.size());
    }
}
