package com.atguigu.builder;

/**
 * 指挥者
 */
public class HouseDirector
{
    HouseBuilder houseBuilder = null;


    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理建造房子的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildHouse();
        houseBuilder.buildWalls();
        return houseBuilder.buildHouse();

    }


}
