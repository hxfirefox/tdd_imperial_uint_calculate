package com.zte.hxfirefox.unittrans;

/**
 * Created by 黄翔 on 15-1-13.
 */
public enum Unit {
    Mile(1),
    Yard(Mile.getRateToMile() * 1000),
    Feet(Yard.getRateToMile() * 1000),
    Inch(Feet.getRateToMile() * 1000);

    private final int rateToMile;

    Unit(int rateToMile) {

        this.rateToMile = rateToMile;
    }

    public int getRateToMile() {
        return rateToMile;
    }
}
