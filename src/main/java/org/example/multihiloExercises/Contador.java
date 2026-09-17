package org.example.multihiloExercises;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Contador implements Runnable{

    private final String name;
    private final int numVueltas;
    private final Random random;

    public Contador(String name, int numVueltas, Random random) {
        this.name = name;
        this.numVueltas = numVueltas;
        this.random = random;
    }

    @Override
    public void run() {
        for (int i = 0; i < numVueltas; i++) {
            int vuelta=i+1;
            System.out.printf("Soy %s, vuelta %d%n", name, vuelta);
            try {
                Thread.sleep(random.nextInt(100, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hola soy Erick");
    }

    public static void main(String[] args) throws InterruptedException {
        Random random1=new Random();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Contador("Contador-1", 6, random1));
        pool.submit(new Contador("Contador-2", 3, random1));
        pool.submit(new Contador("Contador-3", 4, random1));
        pool.submit(new Contador("Contador-4", 2, random1));
        pool.submit(new Contador("Contador-5", 7, random1));

        System.out.println("El main ha terminado");

        pool.shutdown();
    }
}
