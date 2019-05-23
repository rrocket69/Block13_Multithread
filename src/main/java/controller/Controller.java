package controller;

import entities.Docs;
import entities.Impl.DocsImpl;
import entities.Speciality;
import threads.impl.First;
import threads.impl.Second;
import threads.impl.Third;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {
    private static final int CONST = 25;
    private Queue<Docs> bigQueue;
    private int bio;
    private int math;
    private int size;
    private Queue<Docs> queue;

    public Controller(int bio, int math) {
        this.bio = bio;
        this.math = math;
        size = bio + math;
        createList();
        queue = new LinkedBlockingQueue<>();
        addMore(queue);
    }

    public void startAction() {
        new First(queue).start();
        new Second(queue).start();
        new Third(queue).start();
        checkLoop(queue);
    }

    private void checkLoop(Queue<Docs> queue) {
        while (!bigQueue.isEmpty()) {
            if (queue.size() < CONST) {
                addMore(queue);
            }
        }
    }

    private void addMore(Queue<Docs> queue) {
        int rand = new Random().nextInt(CONST) + CONST;
        for (int i = 0; i < rand && bigQueue.peek() != null; i++) {
            queue.add(bigQueue.poll());
        }
    }

    private void createList() {
        bigQueue = new LinkedBlockingQueue<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                bigQueue.add(new DocsImpl(Speciality.Biologist));
                bio--;
            } else {
                bigQueue.add(new DocsImpl(Speciality.Mathematician));
                math--;
            }
        }
    }
}
