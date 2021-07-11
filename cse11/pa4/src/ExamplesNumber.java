

public class ExamplesNumber {
    interface Number {
        int numerator();
        int denominator();
        Number add(Number other);
        Number multiply(Number other);
        String toString();
        double toDouble();
    }

    public class WholeNumber implements Number {
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

    public class Fraction implements Number {
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
            return if (other.getClass() == null) {
                return null;
            }

            else if (other.getClass() == Fraction.class || other.getClass() == WholeNumber.class) {
                return new Fraction(n * other.numerator(), d * other.denominator());
            }

            return null;;
        }

        public String toString() {
            return Integer.toString(n) + "/" + Integer.toString(d);
        }

        public double toDouble() {
            return n / d;
        }
    }
}