package org.example.multihiloExercises;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Contador2 implements Runnable{

    private final String name;
    private final int numVueltas;
    private final Random random;

    public Contador2(String name, int numVueltas, Random random) {
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

        Thread hilo=new Thread(new Contador2("Contador-1", 5, random1));
        Thread hilo2=new Thread(new Contador2("Contador-2", 5, random1));
        Thread hilo3=new Thread(new Contador2("Contador-3", 5, random1));
        Thread hilo4=new Thread(new Contador2("Contador-4", 5, random1));

        hilo.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        System.out.println("El main ha terminado");

    }
}
