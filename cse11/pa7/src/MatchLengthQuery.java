public class MatchLengthQuery extends Query {
    int length;

    MatchLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() == length;
    }
}