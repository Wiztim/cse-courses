public class GreaterLengthQuery extends Query {
    int length;

    GreaterLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() > length;
    }
}