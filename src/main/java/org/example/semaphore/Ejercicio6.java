package org.example.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Ejercicio6 {
    static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(3000);
        semaphore.release();
        semaphore.release();
        semaphore.release();
        try (ExecutorService pool = Executors.newFixedThreadPool(3)) {
            pool.submit(
                    () -> {
                        try {
                            semaphore.acquire();
                            System.out.println("¡Corro!");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            pool.submit(
                    () -> {
                        try {
                            semaphore.acquire();
                            System.out.println("¡Corro!");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
            );
            pool.submit(
                    () -> {
                        try {
                            semaphore.acquire();
                            System.out.println("¡Corro!");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
            );


        }
    }
}
