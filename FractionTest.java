//----------------------------------------------------------------------
// Author: Kai Cheng
//----------------------------------------------------------------------

package fractions;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {

	Fraction f1 = new Fraction(2, 3);
	Fraction f2 = new Fraction(3, 2);
	Fraction f3 = new Fraction(1, 1);
	Fraction f4 = new Fraction(0);
	Fraction f5 = new Fraction(4, 6);
	
	@Test (expected = ArithmeticException.class)
	public void testFractionIntInt() {
		Fraction f6 = new Fraction(999, 1);
		Fraction f7 = new Fraction(-16, 2);
		Fraction f8 = new Fraction(0, 0);
	}
	
	@Test
	public void testFractionInt() {
		Fraction f9 = new Fraction(999);
		Fraction f10 = new Fraction(-16);
		Fraction f11 = new Fraction(0);
	}
	
	public void testFractionString() {
		Fraction f12 = new Fraction("999/1");
		Fraction f13 = new Fraction("-16");
		Fraction f14 = new Fraction("0");
	}
	
    @Test
    public void testAdd() {    	
    	assertEquals(f1.add(f1), new Fraction(4, 3));
    	assertEquals(f1.add(f2), new Fraction(13, 6));
    	assertEquals(f2.add(f3), new Fraction(5, 2));
    }
    
    @Test
    public void testSubtract() {	
    	assertEquals(f1.subtract(f1), new Fraction(0));
    	assertEquals(f1.subtract(f2), new Fraction(-5, 6));
    	assertEquals(f2.subtract(f3), new Fraction(1, 2));
    }
	
    @Test
    public void testMultiply() {
    	assertEquals(f1.multiply(f1), new Fraction(4, 9));
    	assertEquals(f1.multiply(f2), new Fraction(1));
    	assertEquals(f2.multiply(f3), f2);
    	assertEquals(f3.multiply(f4), f4);
    }
	
    @Test (expected = ArithmeticException.class)
    public void testDivide() {    	
    	assertEquals(f1.divide(f1), new Fraction(1));
    	assertEquals(f1.divide(f2), new Fraction(4, 9));
    	assertEquals(f2.divide(f3), new Fraction(3, 2));
    	assertEquals(f2.divide(f4), new Fraction(0, 0));
    }
    
    @Test 
    public void testNegate() {
    	assertEquals(new Fraction(2, 3).negate(), new Fraction(-2, 3));
    	assertEquals(new Fraction(-3, 3).negate(), new Fraction(3, 3));
    	assertEquals(new Fraction(0, 1).negate(), new Fraction(0, 1));
    }
    
    @Test (expected = ArithmeticException.class)
    public void testInverse() {
    	assertEquals(new Fraction(1, 4).inverse(), new Fraction(4, 1));
    	assertEquals(new Fraction(-3, 7).inverse(), new Fraction(-7, 3));
    	assertEquals(new Fraction(7, 3).inverse(), new Fraction(3, 7));
    	assertEquals(new Fraction(0, 3).inverse(), new Fraction(3, 0));
    }

    @Test
    public void testAbs() {
    	assertEquals(new Fraction(1, 6).abs(), new Fraction(1, 6));
    	assertEquals(new Fraction(-8, 7).abs(), new Fraction(8, 7));
    	assertEquals(new Fraction(0, 5).abs(), new Fraction(0, 5));
    }
    
    @Test
    public void testEquals() {
    	assertEquals(f1.equals(f2), false);
    	assertEquals(f1.equals(f1), true);
    	assertEquals(f1.equals(new Fraction(3, 3)), false);
    }
    
    @Test
    public void testHashCode() {
    	assertEquals(f1.hashCode(), 6);
    	assertEquals(f2.hashCode(), 6);
    	assertEquals(f3.hashCode(), 1);
    }
    
    @Test
    public void testCompareTo() {
    	assertEquals(f1.compareTo(f1), 0);
    	assertEquals(f1.compareTo(f2), -1);
    	assertEquals(f2.compareTo(f1), 1);
    }
    
    @Test
    public void testToString() {
    	assertEquals(f1.toString(), "2/3");
    	assertEquals(f2.toString(), "3/2");
    	assertEquals(f3.toString(), "1");
    }
}
