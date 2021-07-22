public class EndsWithQuery extends Query {
    String endingString;

    EndsWithQuery(String string) {
        this.endingString = string;
    }

    boolean matches(String string) {
        return string.endsWith(endingString);
    }
}