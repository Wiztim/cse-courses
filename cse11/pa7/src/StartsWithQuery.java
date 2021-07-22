public class StartsWithQuery extends Query {
    String startingString;

    StartsWithQuery(String string) {
        this.startingString = string;
    }

    boolean matches(String string) {
        return string.startsWith(startingString);
    }
}