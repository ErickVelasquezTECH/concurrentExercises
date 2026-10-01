package org.example.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sala {

    private int contador = 0;

    public void procesar(String nombre) throws InterruptedException {
        Thread.sleep(1000);              // fuera del candado
        synchronized (this) {
            contador++;
        }
    }

    // VERSIÓN B
    public void procesarb(String nombre) throws InterruptedException {
        Thread.sleep(1000);              // fuera del candado
        synchronized (this) {
            contador++;
        }
    }

    public int getContador() {
        return contador;
    }

    public synchronized void entrar(String nombre) throws InterruptedException {
        System.out.println(nombre + " ENTRA");
        Thread.sleep(1000);              // simula trabajo dentro de la sección crítica
        System.out.println(nombre + " SALE");
    }

    public static void main(String[] args) throws InterruptedException {
        Sala salaInformatica = new Sala();

        long inicioA = System.currentTimeMillis();

        Thread hilo1 = new Thread(() -> {
            try {
                salaInformatica.procesar("Erick");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo2 = new Thread(() -> {
            try {
                salaInformatica.procesar("Mary");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo3 = new Thread(() -> {
            try {
                salaInformatica.procesar("Luis");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread hilo4 = new Thread(() -> {
            try {
                salaInformatica.procesar("Ari");
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

        long finA = System.currentTimeMillis();

        System.out.println("Contador: " + salaInformatica.getContador());
        System.out.println("Tiempo: " + (finA - inicioA) + " ms");


    }
}