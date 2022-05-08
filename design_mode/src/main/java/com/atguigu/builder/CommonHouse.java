package com.atguigu.builder;

public class CommonHouse extends HouseBuilder
{

    @Override
    public void buildBasic() {
        System.out.println("1");
    }

    @Override
    public void buildWalls() {
        System.out.println(2);
    }

    @Override
    public void roofed() {
        System.out.println(3);
    }
}
