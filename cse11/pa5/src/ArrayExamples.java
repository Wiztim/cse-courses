import tester.*;

public class ArrayExamples {
    // returns a string with the array contents separated by string
    String joinWith(String[] stringArray, String separator) {
        if (stringArray.length == 0) {
            return "";
        }

        String joinedArray = stringArray[0];
        for (int i = 1; i < stringArray.length; i++) {
            joinedArray += separator + stringArray[i];
        }

        return joinedArray;
    }

    // returns true if all booleans are true
    boolean allTrue(boolean[] booleanArray) {
        for(int i = 0; i < booleanArray.length; i++) {
            if (!booleanArray[i]) {
                return false;
            }
        }

        return true;
    }

    // returns true if all numbers in array are within low and high (inclusive)
    boolean allWithinRange(double[] numArray, double low, double high) {
        for(int i = 0; i < numArray.length; i++) {
            if(numArray[i] < low || numArray[i] > high) {
                return false;
            }
        }
        return true;
    }

    // creates a pair object with the lowest and highest
    Pair maxim(int[] numArray) {
        int highest = numArray[0];
        int lowest = numArray[0];

        for(int i = 0; i < numArray.length; i++) {
            if(highest < numArray[i]) {
                highest = numArray[i];
            }
            else if(lowest > numArray[i]) {
                lowest = numArray[i];
            }
        }

        return new Pair(lowest,highest);
    }

    // returns the alphabetically first string
    String earliest(String[] stringArray) {

        String first = stringArray[0];

        for (int i = 1; i < stringArray.length; i ++) {
            if(first.compareToIgnoreCase(stringArray[i]) > 0) {
                first = stringArray[i];
            }
        }
        return first;
    }

    int lookup(String[] keys, int[] values, String key) {
        for(int i = 0; i < keys.length; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }

        return -1;
    }



    String[] stringArr1 = {"b", "ig", "s", "trin", "gs", "a", "nd", "words"};
    String[] stringArr2 = {"Hello World"};
    String[] stringArr3 = {"Hello", "World"};
    String[] stringArr4 = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
    String[] stringArr5 = {};

    boolean testJoinWith(Tester t) {
        return t.checkExpect(joinWith(stringArr1, "a"), "baigasatrinagsaaandawords") &&
                t.checkExpect(joinWith(stringArr2, "Hello World"), "Hello World") &&
                t.checkExpect(joinWith(stringArr3, " "), "Hello World") &&
                t.checkExpect(joinWith(stringArr4, " "), "The quick brown fox jumps over the lazy dog") &&
                t.checkExpect(joinWith(stringArr5, "123asd"), "");
    }

    boolean testEarliest(Tester t) {
        return t.checkExpect(earliest(stringArr1), "a") &&
                t.checkExpect(earliest(stringArr2), "Hello World") &&
                t.checkExpect(earliest(stringArr3), "Hello") &&
                t.checkExpect(earliest(stringArr4), "brown");
    }

    boolean[] boolArr1 = {true, true, true};
    boolean[] boolArr2 = {false, true, true};
    boolean[] boolArr3 = {true, true, false};
    boolean[] boolArr4 = {};

    boolean testAllTrue(Tester t) {
        return t.checkExpect(allTrue(boolArr1), true) &&
                t.checkExpect(allTrue(boolArr2), false) &&
                t.checkExpect(allTrue(boolArr3), false) &&
                t.checkExpect(allTrue(boolArr4), true);
    }

    double[] doubleArr1 = {1, 2, 3, 4, 5, 6, 7};
    double[] doubleArr2 = {1.1, 1.01, 1.111, 1.0, 1.101, 1.1, 1.11111};
    double[] doubleArr3 = {101.01, 78.9, 45.6, 12.3, 0.123, 234.5};
    double[] doubleArr4 = {-1, 1};
    double[] doubleArr5 = {};

    boolean testAllWithinRange(Tester t) {
        return t.checkExpect(allWithinRange(doubleArr1, 0, 10), true) &&
                t.checkExpect(allWithinRange(doubleArr2, 1.1, 10), false) &&
                t.checkExpect(allWithinRange(doubleArr3, 0, 10), false) &&
                t.checkExpect(allWithinRange(doubleArr4, -1, 1), true) &&
                t.checkExpect(allWithinRange(doubleArr5, 1, 1), true);

    }

    int[] intArr1 = {1, 2, 3, 4, 5, 6, 7};
    int[] intArr2 = {1, -1};
    int[] intArr3 = {-1, 2};
    int[] intArr4 = {7, 5, 4, 3, 1, 7};


    boolean testMaxim(Tester t) {
        return t.checkExpect(maxim(intArr1), new Pair(1, 7)) &&
                t.checkExpect(maxim(intArr2), new Pair(-1, 1)) &&
                t.checkExpect(maxim(intArr3), new Pair(-1, 2)) &&
                t.checkExpect(maxim(intArr4), new Pair(1, 7));
    }

    String[] keys = {"UCSD", "UCLA", "UCI"};
    int[] values = {36000, 44900, 33467};

    boolean testLookup(Tester t) {
        return t.checkExpect(lookup(keys, values, "UCI"), 33467) &&
                t.checkExpect(lookup(keys, values, "UCSD"), 36000) &&
                t.checkExpect(lookup(keys, values, "Stanford"), -1) &&
                t.checkExpect(lookup(keys, values, ""), -1) &&
                t.checkExpect(lookup(keys, values, "ucsd"), -1);
    }
}

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
