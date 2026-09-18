package org.example.multihiloExercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cuenta2 implements Runnable {
    private int saldo = 0;

    public void ingresar(int cantidad) {
        saldo = saldo + cantidad;
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            ingresar(1);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Cuenta2 cuenta = new Cuenta2();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(cuenta);
        pool.submit(cuenta);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(cuenta.getSaldo());

    }


}
