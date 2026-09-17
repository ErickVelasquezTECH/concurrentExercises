package org.example.multihiloExercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sumador2 implements Runnable {
    private int[] dates;

    private final int desde;
    private final int hasta;
    private int suma;

    public Sumador2(int[] dates, int desde, int hasta) {
        this.dates = dates;
        this.desde = desde;
        this.hasta = hasta;
    }

    public int getSuma() {
        return suma;
    }

    @Override
    public void run() {
        for (int i = desde; i <= hasta; i++) {
            suma += dates[i];
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int[] datos = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40
        };

        Sumador2 sumador1 = new Sumador2(datos, 0, 9);
        Sumador2 sumador2 = new Sumador2(datos, 10, 19);
        Sumador2 sumador3 = new Sumador2(datos, 20, 29);
        Sumador2 sumador4 = new Sumador2(datos, 30, 39);

        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.submit(sumador1);
        pool.submit(sumador2);
        pool.submit(sumador3);
        pool.submit(sumador4);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        int total = sumador1.getSuma() + sumador2.getSuma() + sumador3.getSuma() + sumador4.getSuma();

        System.out.println("Total: " + total);
    }

}
