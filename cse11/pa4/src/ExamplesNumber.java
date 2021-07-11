

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
            return other;
        }

        public Number multiply(Number other) {
            return other;
        }

        public String toString() {
            return "";
        }

        public double toDouble() {
            return 0;
        }
    }

    public class Fraction implements Number {
        private int n;
        private int d;

        Fraction(int n) {
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
            return other;
        }

        public Number multiply(Number other) {
            return other;
        }

        public String toString() {
            return "";
        }

        public double toDouble() {
            return 0;
        }
    }
}
