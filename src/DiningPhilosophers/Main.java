package DiningPhilosophers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        ArrayList<Fork> forks = new ArrayList<>(Arrays.asList(new Fork(1), new Fork(2), new Fork(3), new Fork(4), new Fork(5)));

        List<Philosopher> philosophers = Arrays.asList(
                new Philosopher(1, forks),
                new Philosopher(2, forks),
                new Philosopher(3, forks),
                new Philosopher(4, forks),
                new Philosopher(5, forks));


        for (Philosopher p : philosophers)
            p.start();

        try {
            Thread.sleep(20000);
            for (Philosopher p : philosophers)
                p.finish();
            for (Philosopher p : philosophers)
                p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dinners eaten " + Philosopher.getDinnersEaten());
    }
}
