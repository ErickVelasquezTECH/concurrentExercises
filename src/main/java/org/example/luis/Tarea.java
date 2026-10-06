package org.example.luis;

public class Tarea implements Runnable {
    private final String nombre;


    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(nombre + " -> paso " + i);
        }
    }
}
