package org.example.multihiloExercises;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Contador1 implements Runnable{

    private final String name;
    private final int numVueltas;
    private final Random random;

    public Contador1(String name, int numVueltas, Random random) {
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
    }

    public static void main(String[] args) throws InterruptedException {
        Random random1=new Random();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Contador1("Contador-1", 6, random1));

        pool.submit(new Contador1("Contador-2", 3, random1));
        pool.submit(new Contador1("Contador-3", 4, random1));
        pool.submit(new Contador1("Contador-4", 2, random1));
        pool.submit(new Contador1("Contador-5", 7, random1));

        System.out.println("El main ha terminado");

        pool.shutdown();
    }
}
