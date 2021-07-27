public class MatchesWordQuery extends Query {
    String matchesWord;

    MatchesWordQuery(String string) {
        this.matchesWord = string;
    }

    boolean matches(String string) {
        String[] words = string.split(" ");

        for (String word : words) {
            if (word.equals(matchesWord)) {
                return true;
            }
        }

        return false;
    }
}