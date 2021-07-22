public class ContainsStringQuery extends Query {
    String containedString;

    ContainsStringQuery(String string) {
        this.containedString = string;
    }

    boolean matches(String string) {
        return string.contains(containedString);
    }
}