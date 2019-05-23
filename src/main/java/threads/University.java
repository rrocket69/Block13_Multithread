package threads;

import entities.Docs;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class University extends Thread {
    protected Queue<Docs> queue;
    protected Queue<Docs> accepted;

    protected University(Queue<Docs> queue) {
        this.queue = queue;
        accepted = new ConcurrentLinkedQueue<>();
    }

    protected void sendSleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
