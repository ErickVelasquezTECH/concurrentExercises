package org.example.multihiloExercises;

import java.util.Random;

public class Tortugas implements Runnable {
    private String name;
    private int numberStep;
    private Random random;

    public Tortugas(String name, int numberStep) {
        this.name = name;
        this.numberStep = numberStep;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%s paso: %d", name, vuelta);
            try {
                Thread.sleep(random.nextInt(50  , 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
