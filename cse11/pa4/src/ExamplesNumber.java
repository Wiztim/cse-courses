import tester.*;

interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toString();
    double toDouble();
}

class WholeNumber implements Number {
    private int n;

    WholeNumber(int n) {
        this.n = n;
    }

    public int numerator() {
        return n;
    }

    public int denominator() {
        return 1;
    }

    public Number add(Number other) {
        if (other.getClass() == null) {
            return null;
        }

        else if (other.getClass() == WholeNumber.class) {
            return new WholeNumber(n + other.numerator());
        }

        else if (other.getClass() == Fraction.class) {
            return new Fraction(n * other.denominator() + other.numerator(), other.denominator());
        }

        return null;
    }

    public Number multiply(Number other) {
        if (other.getClass() == null) {
            return null;
        }

        else if (other.getClass() == WholeNumber.class) {
            return new WholeNumber(n * other.numerator());
        }

        else if (other.getClass() == Fraction.class) {
            return new Fraction(n * other.numerator(), other.denominator());
        }

        return null;
    }

    public String toString() {
        return Integer.toString(n);
    }

    public double toDouble() {
        return n;
    }
}

class Fraction implements Number {
    private int n;
    private int d;

    Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public int numerator() {
        return n;
    }

    public int denominator() {
        return d;
    }

    public Number add(Number other) {
        if (other.getClass() == null) {
            return null;
        }

        else if (other.getClass() == Fraction.class || other.getClass() == WholeNumber.class) {
            return new Fraction(n * other.denominator() + d * other.numerator(), d * other.denominator());
        }

        return null;
    }

    public Number multiply(Number other) {
        if (other.getClass() == null) {
            return null;
        }

        else if (other.getClass() == Fraction.class || other.getClass() == WholeNumber.class) {
            return new Fraction(n * other.numerator(), d * other.denominator());
        }

        return null;
    }

    public String toString() {
        return Integer.toString(n) + "/" + Integer.toString(d);
    }

    public double toDouble() {
        return (double) (n) / d;
    }
}

public class ExamplesNumber {


    Number number = new WholeNumber(5);

    public boolean testToString(Tester t) {
        return t.checkExpect(number.toString(),"5");
    }

    // Exploration
    double num1 = 0.1 + 0.2 + 0.3;
    double num2 = 0.1 + (0.2 + 0.3);
    String stringNum1 = Double.toString(num1);
    String stringNum2 = Double.toString(num2);
}