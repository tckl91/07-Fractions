//----------------------------------------------------------------------
// Author: Kai Cheng
//----------------------------------------------------------------------

public class Fraction {
	private int numerator;
	private int denominator;

	private static int gcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcd(num2, num1 % num2);
	}

	public Fraction(int numumerator, int denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Denominator Cannot Be 0.");
		}
		this.numerator = numumerator;
		this.denominator = denominator;
		normalize();
	}

	public Fraction(int num) {
		this(num, 1);
	}

	public Fraction() {
		this(0, 1);
	}

	public Fraction add(Fraction f) {
		return new Fraction((numerator * f.denominator) + (f.numerator * denominator), denominator * f.numerator);
	}

	public Fraction sub(Fraction f) {
		return new Fraction((numerator * f.denominator) - (f.numerator * denominator), denominator * f.numerator);
	}

	public Fraction multiply(Fraction f) {
		return new Fraction(numerator * f.numerator, denominator * f.numerator);
	}

	public Fraction divide(Fraction f) {
		return new Fraction(numerator * f.denominator, denominator * f.numerator);
	}

	private void normalize() {
		assert denominator != 0 : "Can't Divide By 0.";
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		else if (numerator == 0) {
			denominator = 1;
		}
		else {
			int gcdnum = gcd(numerator, denominator);
			numerator /= gcdnum;
			denominator /= gcdnum;
		}
	}

	public boolean equals(Object o) {
		if (!(o instanceof Fraction)) {
			return false;
		}
		Fraction f = (Fraction) o;
		return (numerator == f.numerator) && (denominator == f.denominator);
	}

	public int hashCode() {
		return numerator * denominator;
	}

	public Fraction negate() {
		return new Fraction(-numerator, denominator);
	}

	public Fraction abs() {
		if (numerator >= 0) {
			return this;
		}
		return negate();
	}

	public Fraction inverse() {
		if (numerator == 0) {
			throw new ArithmeticException("Can't Invert 0.");
		}
		else if (numerator < 0) {
			return new Fraction(-denominator, -numerator);
		}
		else {
			return new Fraction(denominator, numerator);
		}
	}

	public int compareTo(Fraction f) {
		if (numerator * f.denominator == f.numerator * denominator) {
			return 0;
		}
		else if (numerator * f.denominator < f.numerator * denominator) {
			return -1;
		}
		else {
			return 1;
		}
	}

	public String toString() {
		if (numerator == 1) {
			return "" + numerator;
		}
		else {
			return "" + numerator + "/" + denominator;
		}
	}
}
