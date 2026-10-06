package org.example.luis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable runn= () -> {
            for (int i = 0; i <5 ; i++) {
                System.out.println("Paso: "+i);
            }
        };

        Thread hilo= new Thread(runn);



    }
}
