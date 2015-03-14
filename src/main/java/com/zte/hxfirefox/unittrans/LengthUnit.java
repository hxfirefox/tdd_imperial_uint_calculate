package com.zte.hxfirefox.unittrans;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.zte.hxfirefox.unittrans.Unit.*;

/**
 * Created by 黄翔 on 15-1-13.
 */
public class LengthUnit {
    private final double amount;
    private final Unit unit;

    public LengthUnit(double amount, Unit unit) {
        checkNotNull(unit, "unit should not be null");
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LengthUnit that = (LengthUnit) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (unit != that.unit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public LengthUnit getAmountUnit(Unit newUnit) {
        return new LengthUnit(amount * getRate(newUnit), newUnit);
    }

    private double getRate(Unit newUnit) {
        return (double) newUnit.getRateToMile() / this.unit.getRateToMile();
    }

    public double getAmount() {
        return amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public LengthUnit add(LengthUnit lengthUnit) {
        final double newAmount = lengthUnit.getAmountUnit(Mile).getAmount()
                + this.getAmountUnit(Mile).getAmount();
        return new LengthUnit(newAmount, Mile);
    }

    public LengthUnit sub(LengthUnit lengthUnit) {
        final double newAmount = this.getAmountUnit(Mile).getAmount()
                - lengthUnit.getAmountUnit(Mile).getAmount();
        return new LengthUnit(newAmount, Mile);
    }
}
