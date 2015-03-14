package com.zte.hxfirefox.unittrans;

import org.junit.Test;

import static com.zte.hxfirefox.unittrans.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by 黄翔 on 15-1-13.
 */
public class LengthUnitTest {
    private LengthUnit lengthUnit;

    @Test(expected = Exception.class)
    public void should_throw_exception_when_unit_is_null() throws Exception {
        // given
        // when
        lengthUnit = new LengthUnit(1.0, null);
        // then
    }

    @Test
    public void should_equal_when_same_lenght_and_unit() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1.0, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(1.0, Mile);
        // when
        final boolean equals = lengthUnit1.equals(lengthUnit2);
        // then
        assertThat(equals, is(true));
    }

    @Test
    public void should_not_equal_when_same_lenght_but_different_unit() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1.0, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(1.0, Yard);
        // when
        final boolean equals = lengthUnit1.equals(lengthUnit2);
        // then
        assertThat(equals, is(false));
    }

    @Test
    public void should_not_equal_when_different_length_but_same_unit() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(2.0, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(1.0, Mile);
        // when
        final boolean equals = lengthUnit1.equals(lengthUnit2);
        // then
        assertThat(equals, is(false));
    }

    @Test
    public void should_1_mile_equal_1000_yard() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1.0, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(1000.0, Yard);
        // when
        final boolean equals = lengthUnit1.getAmountUnit(Yard).equals(lengthUnit2);
        // then
        assertThat(equals, is(true));
    }

    @Test
    public void should_0dot1_mile_equal_100_yard() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(0.1, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(100.0, Yard);
        // when
        final boolean equals = lengthUnit1.getAmountUnit(Yard).equals(lengthUnit2);
        // then
        assertThat(equals, is(true));
    }

    @Test
    public void should_return_1000_length_and_yard_unit_when_1_mile_base_unit_yard() throws Exception {
        // given
        lengthUnit = new LengthUnit(1.0, Mile);
        // when
        final LengthUnit lengthUnit1 = lengthUnit.getAmountUnit(Yard);
        // then
        assertThat(lengthUnit1.getAmount(), is(1000.0));
        assertThat(lengthUnit1.getUnit(), is(Yard));
    }

    @Test
    public void should_return_1000_length_and_feet_unit_when_1_yard_base_unit_feet() throws Exception {
        // given
        lengthUnit = new LengthUnit(1.0, Yard);
        // when
        final LengthUnit lengthUnit1 = lengthUnit.getAmountUnit(Feet);
        // then
        assertThat(lengthUnit1.getAmount(), is(1000.0));
        assertThat(lengthUnit1.getUnit(), is(Feet));
    }

    @Test
    public void should_1_mile_add_1000_yard_equal_2000_yard() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1, Mile);
        LengthUnit lengthUnit2 = new LengthUnit(1000.0, Yard);
        // when
        final LengthUnit lengthUnit3 = lengthUnit1.add(lengthUnit2).getAmountUnit(Yard);
        // then
        assertThat(lengthUnit3.getAmount(), is(2000.0));
    }

    @Test
    public void should_1_yard_add_800_feet_equal_1dot8_yard() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1, Yard);
        LengthUnit lengthUnit2 = new LengthUnit(800.0, Feet);
        // when
        final LengthUnit lengthUnit3 = lengthUnit1.add(lengthUnit2).getAmountUnit(Yard);
        // then
        assertThat(lengthUnit3.getAmount(), is(1.8));
    }

    @Test
    public void should_1_yard_sub_800_feet_equal_0dot2_yard() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(1, Yard);
        LengthUnit lengthUnit2 = new LengthUnit(800.0, Feet);
        // when
        final LengthUnit lengthUnit3 = lengthUnit1.sub(lengthUnit2).getAmountUnit(Yard);
        // then
        assertEquals(lengthUnit3.getAmount(), 0.2, 0.01);
    }

    @Test
    public void should_800_yard_sub_1_mile_equal_minus_0dot2_mile() throws Exception {
        // given
        LengthUnit lengthUnit1 = new LengthUnit(800.0, Yard);
        LengthUnit lengthUnit2 = new LengthUnit(1.0, Mile);
        // when
        final LengthUnit lengthUnit3 = lengthUnit1.sub(lengthUnit2).getAmountUnit(Mile);
        // then
        assertEquals(lengthUnit3.getAmount(), -0.2, 0.01);
    }
}
