package org.example.multihiloExercises;

import java.util.Random;

public class Tortugas implements Runnable {
    private final String name;
    private final Random random;

    public Tortugas(String name, Random random) {
        this.name = name;
        this.random = random;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%s paso: %d%n", name, i);
            try {
                Thread.sleep(random.nextInt(50  , 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("!%s ha llegado a la meta!%n",name);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread hilo1= new Thread(new Tortugas("Tortuga-1",new Random()));
        Thread hilo2= new Thread(new Tortugas("Tortuga-2",new Random()));
        Thread hilo3= new Thread(new Tortugas("Tortuga-3",new Random()));
        Thread hilo4= new Thread(new Tortugas("Tortuga-4",new Random()));
        Thread hilo5= new Thread(new Tortugas("Tortuga-5",new Random()));
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        hilo5.join();

        System.out.println("Carrera terminada");
    }
}
