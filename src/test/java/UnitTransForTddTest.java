import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class UnitTransForTddTest {

    private UnitTransForTdd unitTransForTdd;

    @Before
    public void setUp() throws Exception {
        unitTransForTdd = new UnitTransForTdd();
    }

    @org.junit.Test
    public void should_return_true_when_input_unit_using_mile() throws Exception {
        // given
        // when
        final ValueWithImperialUnit v = unitTransForTdd.inputWithImperialUnit(1, "mile");
        // then
        assertThat(v, is(notNullValue()));
    }

    @Test
    public void should_return_true_when_input_uint_using_yard() throws Exception {
        // given
        // when
        final ValueWithImperialUnit v = unitTransForTdd.inputWithImperialUnit(2, "yard");
        // then
        assertThat(v, is(notNullValue()));
    }

    @Test
    public void should_return_true_when_input_unit_using_feet() throws Exception {
        // given
        // when
        final ValueWithImperialUnit v = unitTransForTdd.inputWithImperialUnit(3, "feet");
        // then
        assertThat(v, is(notNullValue()));
    }

    @Test
    public void should_return_true_when_input_unit_using_inch() throws Exception {
        // given
        // when
        final ValueWithImperialUnit v = unitTransForTdd.inputWithImperialUnit(4, "inch");
        // then
        assertThat(v, is(notNullValue()));
    }

    @Test
    public void should_return_false_when_input_unit_using_invalid_unit() throws Exception {
        // given
        // when
        final ValueWithImperialUnit v = unitTransForTdd.inputWithImperialUnit(1, "kilometer");
        // then
        assertThat(v, is(notNullValue()));
    }

    @Test
    public void should_equal_1_mile_when_input_1_mile() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(1, "mile");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(1, "mile");
        // when
        final boolean result = unitTransForTdd.equalWithInputVal(v1, v2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void should_equal_1760_yard_when_input_1_mile() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(1760, "yard");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(1, "mile");
        // when
        final boolean result = unitTransForTdd.equalWithInputVal(v1, v2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void should_equal_3_feet_when_input_1_yard() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(3, "feet");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(1, "yard");
        // when
        final boolean result = unitTransForTdd.equalWithInputVal(v1, v2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void should_equal_12_inch_when_input_1_feet() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(12, "inch");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(1, "feet");
        // when
        final boolean result = unitTransForTdd.equalWithInputVal(v1, v2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void should_equal_2_feet_when_13_inch_add_11_inch() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(2, "feet");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(13, "inch");
        ValueWithImperialUnit v3 = unitTransForTdd.inputWithImperialUnit(11, "inch");
        // when
        final ValueWithImperialUnit vSum = unitTransForTdd.addWithInputVal(v2, v3);
        vSum.transUnitUp(vSum);
        // then
        final boolean result = unitTransForTdd.equalWithInputVal(vSum, v1);
        assertThat(result, is(true));
        assertThat(vSum.getVal(), is(2));
        assertThat(vSum.getUnit(), is("feet"));
    }

    @Test
    public void should_equal_3_yard_when_2_yard_add_3_feet() throws Exception {
        // given
        ValueWithImperialUnit v1 = unitTransForTdd.inputWithImperialUnit(3, "yard");
        ValueWithImperialUnit v2 = unitTransForTdd.inputWithImperialUnit(2, "yard");
        ValueWithImperialUnit v3 = unitTransForTdd.inputWithImperialUnit(3, "feet");
        // when
        final ValueWithImperialUnit vSum = unitTransForTdd.addWithInputVal(v2, v3);
        vSum.transUnitUp(vSum);
        // then
        final boolean result = unitTransForTdd.equalWithInputVal(vSum, v1);
        assertThat(result, is(true));
        assertThat(vSum.getVal(), is(3));
        assertThat(vSum.getUnit(), is("yard"));
    }
}