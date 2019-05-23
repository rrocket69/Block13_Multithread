package threads.impl;

import entities.Docs;
import entities.Speciality;
import threads.University;

import java.util.Queue;

public class Third extends University {
    public Third(Queue<Docs> queue) {
        super(queue);

    }

    public void run() {
        while (queue.peek()!=null) {
            if (queue.peek().getCurrent().equals(Speciality.Mathematician)) {
                accepted.add(queue.poll());
            } else {
                sendSleep();
            }
        }
        System.out.println("Third " + accepted.size());
    }
}
