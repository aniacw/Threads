package DiningPhilosophers;

import java.util.ArrayList;
import java.util.List;


public class Philosopher extends Thread {
    public static int getDinnersEaten() {
        return dinnersEaten;
    }

    static int dinnersEaten = 0;

    private String name;
    private boolean isEating;
    private Fork forkLeft;
    private Fork forkRight;
    private int id;
    private volatile boolean running;

    synchronized private static void dinnerFinished(){
        dinnersEaten++;
    }

    public Philosopher(int id, List<Fork> forks) throws NoSuchFieldException, IllegalAccessException {
        isEating = false;
        this.id = id;
        calculateForks(forks);
    }

    private void calculateForks(List<Fork> forks) {
        forkLeft = forks.get(id - 1);
        forkRight = forks.get(id % forks.size());
    }


    public void eat() {
        try {
            System.out.println(id + " eating...");
            Thread.sleep(400);
            //System.out.println(id + " end of dinner, forks released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkForks() {
        while (true) {
            //czeka az widelec sie zwolni (lock), spr czy dost i blokuje lub leci dalej (trylock)
            if (forkLeft.tryTake()) {
                //System.out.println(id + " L");
                if (forkRight.tryTake(30)) {
                    //System.out.println(id + " R");
                    break;
                } else
                    forkLeft.release();
            }
            if (forkRight.tryTake()) {
                //System.out.println(id +" R");
                if (forkLeft.tryTake(30)) {
                    //System.out.println(id + " L");
                    break;
                }else
                    forkRight.release();
            }
        }


//        while (true) {
//            //czeka az widelec sie zwolni (lock), spr czy dost i blokuje lub leci dalej (trylock)
//            if (forkLeft.tryTake()) {
//                forkRight.take();
//                break;
//            }
//            if (forkRight.tryTake()) {
//                forkLeft.take();
//                break;
//            }
//        }


//        forkLeft.take();
//        forkRight.take();


        eat();
        dinnerFinished();
        forkLeft.release();
        forkRight.release();
    }


    public int getPhilId() {
        return id;
    }

    public void contemplate() {
        try {
            System.out.println(id + " contemplating...");
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finish(){
        running=false;
    }

    public void run() {
        running=true;
        while (running) {
            checkForks();
            contemplate();
        }
    }
}
