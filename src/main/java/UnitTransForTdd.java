
public class UnitTransForTdd {

    public ValueWithImperialUnit inputWithImperialUnit(int value, String unit) {
        final boolean b = isValidUnit(unit);
        return b ? new ValueWithImperialUnit(value, unit) : null;
    }

    private boolean isValidUnit(String unit) {
        return unit.equals(ValueWithImperialUnit.MILE)
                || unit.equals(ValueWithImperialUnit.YARD)
                || unit.equals(ValueWithImperialUnit.FEET)
                || unit.equals(ValueWithImperialUnit.INCH);
    }

    public boolean equalWithInputVal(ValueWithImperialUnit srcValue,
                                     ValueWithImperialUnit dstValue) {
        return srcValue.equalsValue(dstValue);
    }

    public ValueWithImperialUnit addWithInputVal(ValueWithImperialUnit srcValue,
                                                 ValueWithImperialUnit dstValue) {
        return new ValueWithImperialUnit(
                srcValue.transValueToInch(srcValue) + dstValue.transValueToInch(dstValue),
                ValueWithImperialUnit.INCH);
    }
}