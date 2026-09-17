package org.example.multihiloExercises;

class Sumador implements Runnable {
    private final int[] dates;

    private final int desde;
    private final int hasta;
    private int suma;

    public Sumador(int[] dates, int desde, int hasta) {
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

        Sumador sumador1=new Sumador(datos, 0,9);
        Sumador sumador2=new Sumador(datos, 10,19);
        Sumador sumador3=new Sumador(datos, 20,29);
        Sumador sumador4=new Sumador(datos, 30,39);
        Thread hilo1=new Thread(sumador1);
        Thread hilo2=new Thread(sumador2);
        Thread hilo3=new Thread(sumador3);
        Thread hilo4=new Thread(sumador4);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        int total=sumador1.getSuma()+sumador2.getSuma()+ sumador3.getSuma()+sumador4.getSuma();
        System.out.println(total);


    }

}
