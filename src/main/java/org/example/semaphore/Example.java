package org.example.semaphore;

import java.util.concurrent.Semaphore;

public class Example {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);   // 1

        semaphore.acquire(1);                     //-1

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                for (int i = 0; i < 1000; i++) {
                    System.out.println(1);
                }
                // EJECUTA TAREAS
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
                for (int i = 0; i < 1000; i++) {
                    System.out.println(2);
                }
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();


        semaphore.release();                      // el principal devuelve su permiso
    }
}
