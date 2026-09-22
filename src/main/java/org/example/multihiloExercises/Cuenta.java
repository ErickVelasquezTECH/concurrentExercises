package org.example.multihiloExercises;

public class Cuenta implements Runnable {
    private int saldo = 0;

    public void ingresar(int cantidad) {
        synchronized (this) {
            saldo = saldo + cantidad;
        }
    }

    public void sacar(int cantidad) {
        synchronized (this) {
            saldo = saldo - cantidad;
        }
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            ingresar(1);
            sacar(1);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta = new Cuenta();

        Thread hilo1 = new Thread(cuenta);
        Thread hilo2 = new Thread(cuenta);

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();

        System.out.println(cuenta.getSaldo());

    }


}
