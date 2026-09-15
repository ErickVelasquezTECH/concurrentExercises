package org.example.task;

public class Tarea implements Runnable {
    private final String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println(nombre + " -> paso " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Crea el hilo a partir de la definición del runnable
        Thread hilo = new Thread(new Tarea("A"));
        // Se ejecutará en el nuevo hilo lo que hay en el método run()
        hilo.start();
        //El hilo se queda bloqueado
        hilo.join();
        // Esta sentencia se ejecuta inmediatamente después de arrancar hilo,
        // no espera a que acabe
        System.out.println("Fin");
    }
}



