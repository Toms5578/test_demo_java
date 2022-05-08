package com.atguigu.builder;

/**
 * 抽象的建造者
 */
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造流程写好
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    /**
     * 建造房子，
     * @return 产品
     */
    public House buildHouse()
    {
        return house;
    }


}
