package threads.impl;

import entities.Docs;
import entities.Speciality;
import threads.University;

import java.util.Queue;

public class First extends University {
    public First(Queue<Docs> queue) {
        super(queue);

    }

    public void run() {
        while (queue.peek() != null) {
            if (queue.peek().getCurrent().equals(Speciality.Biologist)) {
                accepted.add(queue.poll());
            } else {
                sendSleep();
            }
        }
        System.out.println("First " + accepted.size());
    }
}
