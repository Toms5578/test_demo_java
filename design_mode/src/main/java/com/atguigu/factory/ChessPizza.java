package com.atguigu.factory;

public class ChessPizza implements Pizaa {
    public void perpare() {
        System.out.println("Chess perare");
    }

    public void bake() {
        System.out.println("ChessPizza bake");
    }

    public void cut() {
        System.out.println("ChessPizza cut");
    }

    public void box() {
        System.out.println("ChessPizza box");
    }
}
