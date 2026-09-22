package org.example.semaphore;

public class Ej3 {
    public static void main(String[] args) throws InterruptedException {
        Contador contador1 = new Contador();
        Contador contador2 = new Contador();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) contador1.incrementar();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) contador2.incrementar();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("contador1 = " + contador1.getValor());
        System.out.println("contador2 = " + contador2.getValor());
    }
}
