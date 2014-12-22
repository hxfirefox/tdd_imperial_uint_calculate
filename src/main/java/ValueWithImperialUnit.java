import java.util.HashMap;

public class ValueWithImperialUnit {
    public static final int MILE_TO_YARD = 1760;
    public static final int YARD_TO_FEET = 3;
    public static final int FEET_TO_INCH = 12;
    public static final int INCH_TO_INCH = 1;
    public static final String MILE = "mile";
    public static final String YARD = "yard";
    public static final String FEET = "feet";
    public static final String INCH = "inch";
    private static HashMap<String, Integer> unitFactor = new HashMap<String, Integer>();
    private int val;
    private String unit;

    static {
        unitFactor.put(MILE, MILE_TO_YARD * YARD_TO_FEET * FEET_TO_INCH * INCH_TO_INCH);
        unitFactor.put(YARD, YARD_TO_FEET * FEET_TO_INCH * INCH_TO_INCH);
        unitFactor.put(FEET, FEET_TO_INCH * INCH_TO_INCH);
        unitFactor.put(INCH, INCH_TO_INCH);
    }

    public ValueWithImperialUnit(int val, String unit) {
        this.val = val;
        this.unit = unit;
    }

    public int getVal() {
        return val;
    }

    public String getUnit() {
        return unit;
    }

    public boolean equalsValue(ValueWithImperialUnit target) {
        return transValueToInch(this) == transValueToInch(target);
    }

    public int transValueToInch(ValueWithImperialUnit value) {
        return value.getVal() * unitFactor.get(value.getUnit());
    }

    public ValueWithImperialUnit transUnitUp(ValueWithImperialUnit v) {
        if (v.getVal() % (FEET_TO_INCH * YARD_TO_FEET) != 0) {
            v.setVal(v.getVal() / FEET_TO_INCH);
            v.setUnit(FEET);
        } else if (v.getVal() % (FEET_TO_INCH * YARD_TO_FEET * MILE_TO_YARD) != 0) {
            v.setUnit(YARD);
            v.setVal(v.getVal() / (FEET_TO_INCH * YARD_TO_FEET));
        } else if (v.getVal() % (FEET_TO_INCH * YARD_TO_FEET * MILE_TO_YARD) == 0) {
            v.setVal(v.getVal() / (FEET_TO_INCH * YARD_TO_FEET * MILE_TO_YARD));
            v.setUnit(MILE);
        }
        return v;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
