package org.example.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sala {

    public synchronized void entrar(String nombre) throws InterruptedException {
        System.out.println(nombre + " ENTRA");
        Thread.sleep(1000);              // simula trabajo dentro de la sección crítica
        System.out.println(nombre + " SALE");

    }

    public static void main(String[] args) throws InterruptedException {
        Sala salaInformatica = new Sala();

        Thread hilo1 = new Thread(() -> {
            try {
                salaInformatica.entrar("Erick");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo2 = new Thread(() -> {
            try {
                salaInformatica.entrar("Mary");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo3 = new Thread(() -> {
            try {
                salaInformatica.entrar("Luis");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo4 = new Thread(() -> {
            try {
                salaInformatica.entrar("Ari");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();



    }
}