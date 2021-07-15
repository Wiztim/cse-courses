import tester.*;

public class LongStrings {
    String[] longStrings(String[] stringArr, int stringLength) {
        int count = 0;
        for (String string : stringArr) {
            if (string.length() >= stringLength) {
                count++;
            }
        }

        String[] longStrings = new String[count];
        int index = 0;
        for (String string : stringArr) {
            if (string.length() >= stringLength) {
                longStrings[index] = string;
                index++;
            }
        }

        return longStrings;
    }

    String[] stringArr1 = {};
    String[] stringArr2 = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};

    boolean testLongStrings(Tester t) {
        return t.checkExpect(longStrings(stringArr1, 1), new String[]{}) &&
                t.checkExpect(longStrings(stringArr2, 4), new String[]{"quick", "brown", "jumps", "over", "lazy"}) &&
                t.checkExpect(longStrings(stringArr2, 10), new String[]{}) &&
                t.checkExpect(longStrings(stringArr2, 0), new String[]{"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"});
    }
}
