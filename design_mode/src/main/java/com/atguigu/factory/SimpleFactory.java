package com.atguigu.factory;

/**
 * 简单工厂类
 * @author sly
 */
public class SimpleFactory {

    public Pizaa createPizza(String type)
    {
        if ("Chess".equals(type)) {
            return new ChessPizza();
        } else if ("b".equals(type)) {
            return new ChessPizza();
        }
        throw new IllegalStateException("Unexpected value: " + type);
    }


}
