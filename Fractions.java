//----------------------------------------------------------------------
// Author: Kai Cheng
//----------------------------------------------------------------------

package fractions;

public class Fraction {
	private int numerator;
	private int denominator;

	Fraction(int numumerator, int denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Denominator Cannot Be 0.");
		}
		if (denominator < 0){
			numerator *= -1;
			denominator *= -1;
		}
		
		this.numerator = numumerator;
		this.denominator = denominator;
		normalize();
	}

	Fraction(int num) {
		this.numerator = num;
		this.denominator = 1;
	}

	Fraction(String str) {
		String[] nums = str.split("/");
		if (nums.length == 1){
			this.numerator = Integer.parseInt(nums[0].trim());
			this.denominator = 1;
		}
		else {
			this.numerator = Integer.parseInt(nums[0].trim());
			this.denominator = Integer.parseInt(nums[1].trim());
			if (this.denominator == 0) {
				throw new ArithmeticException("Denominator cannot be zero!");
			}
			if (this.denominator < 0) {
				this.numerator *= -1;
				this.denominator *= -1;
			}
			normalize();
		}	
	}

	public Fraction add(Fraction f) {
		return new Fraction((numerator * f.denominator + f.numerator * denominator), denominator * f.denominator);
	}

	public Fraction subtract(Fraction f) {
		return new Fraction((numerator * f.denominator) - (f.numerator * denominator), denominator * f.denominator);
	}

	public Fraction multiply(Fraction f) {
		return new Fraction(numerator * f.numerator, denominator * f.denominator);
	}

	public Fraction divide(Fraction f) {
		return new Fraction(numerator * f.denominator, denominator * f.numerator);
	}

	private void normalize() {
		int defaultNum = numerator;
		int defaultDenom = denominator;
		int temp;
		
		while (denominator != 0) {
			temp = denominator;
			denominator = numerator % denominator;
			numerator = temp;
		}
		int common = numerator;
		numerator = defaultNum / Math.abs(common);
		denominator = defaultDenom / Math.abs(common);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Fraction)) {
			return false;
		}
		Fraction f = (Fraction) o;
		return ((numerator == f.numerator) && (denominator == f.denominator));
	}

	@Override
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
		if (numerator / denominator == f.numerator / f.denominator) {
			return 0;
		}
		else if (numerator / denominator < f.numerator / f.denominator) {
			return -1;
		}
		else {
			return 1;
		}
	}

	@Override
	public String toString() {
		if (denominator == 1) {
			return Integer.toString(numerator);
		}
		else {
			return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
