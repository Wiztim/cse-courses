public class NotQuery extends Query {
    Query query;

    NotQuery(Query query) {
        this.query = query;
    }

    boolean matches(String string) {
        return !query.matches(string);
    }
}
