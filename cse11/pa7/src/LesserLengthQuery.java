public class LesserLengthQuery extends Query {
    int length;

    LesserLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() < length;
    }
}