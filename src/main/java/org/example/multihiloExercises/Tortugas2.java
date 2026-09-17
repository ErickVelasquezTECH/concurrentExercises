package org.example.multihiloExercises;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tortugas2 implements Runnable {
    private final String name;
    private final Random random;

    public Tortugas2(String name, Random random) {
        this.name = name;
        this.random = random;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%s paso: %d%n", name, i);
            try {
                Thread.sleep(random.nextInt(50, 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("!%s ha llegado a la meta!%n", name);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            pool.submit(new Tortugas(("Tortuga-" + i), new Random()));
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Carrera terminada");


    }
}
