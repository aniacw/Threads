package DiningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private String name;
    private Lock inUse;
    private int id;

    public Fork(int id) {
        inUse = new ReentrantLock();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void take(){
        inUse.lock();
    }

    public boolean tryTake(){
        return inUse.tryLock();
    }

    public boolean tryTake(long waitTime){
        try {
            return inUse.tryLock(waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void release(){
        inUse.unlock();
    }
}
