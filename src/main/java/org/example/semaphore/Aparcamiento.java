package org.example.semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

public class Aparcamiento {
    static Semaphore semaphore = new Semaphore(3);

    private void aparcar(int coche) {
        try {

            System.out.println("Coche " + coche + " llega");
            semaphore.acquire();
            System.out.println("Coche " + coche + " APARCA (Plazas libres: " + semaphore.availablePermits() + ")");
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 3000));
            System.out.println("   Coche " + coche + " se va");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Aparcamiento aparcamiento = new Aparcamiento();

        try (ExecutorService pool = Executors.newFixedThreadPool(8)) {
            pool.submit(() -> {
                aparcamiento.aparcar(1);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(2);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(3);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(4);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(5);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(6);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(7);
            });
            pool.submit(() -> {
                aparcamiento.aparcar(8);
            });
        }
    }
}
