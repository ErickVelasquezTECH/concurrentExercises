package org.example.problems;

public class Cuenta {
    private String name;
    private int saldo;

    public Cuenta(String name, int saldo) {
        this.name = name;
        this.saldo = saldo;
    }

    public boolean retirar(int cantidad) {
        if (saldo >= cantidad) {          // 1. comprobar
            saldo = saldo - cantidad;     // 2. actuar
            return true;
        }
        return false;
    }
    public void ingresar(int cantidad) {
        saldo=saldo+cantidad;
    }



    public int getSaldo() {
        return saldo;
    }

    public String getName() {
        return name;
    }
}
