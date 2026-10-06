package org.example.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Transfer {


    public static void transferir(Cuenta origen, Cuenta destino, int cantidad) {
        Cuenta first;
        Cuenta second;

        if (origen.getName().compareTo(destino.getName())>0){
            first=origen;
            second=destino;
        }else {
            first=destino;
            second=origen;
        }


        synchronized (first) {
            synchronized (second) {
                origen.retirar(cantidad);
                destino.ingresar(cantidad);
            }
        }
    }

    public static void main(String[] args) {
        Cuenta a = new Cuenta("A", 10_000);
        Cuenta b = new Cuenta("B", 10_000);
        Runnable tarea1 = () -> {
            for (int i = 0; i < 100_000; i++) transferir(a, b, 1);
        };
        Runnable tarea2 = () -> {
            for (int i = 0; i < 100_000; i++) transferir(b, a, 1);
        };
        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            pool.submit(tarea1);
            pool.submit(tarea2);
        }


    }
}
