public abstract class Query {
    abstract boolean matches(String string);
}

class matchLengthQuery extends Query {
    int length;

    matchLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() == length;
    }
}

class greaterLengthQuery extends Query {
    int length;

    greaterLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() > length;
    }
}

class lesserLengthQuery extends Query {
    int length;

    lesserLengthQuery(int length) {
        this.length = length;
    }

    boolean matches(String string) {
        return string.length() < length;
    }
}

class containsString extends Query {
    String storedString;

    containsString(String string) {
        this.storedString = string;
    }

    boolean matches(String string) {
        return storedString.contains(string);
    }
}

class startsWith extends Query {
    String storedString;

    startsWith(String string) {
        this.storedString = string;
    }

    boolean matches(String string) {
        return storedString.startsWith(string);
    }
}

class endsWith extends Query {
    String storedString;

    endsWith(String string) {
        this.storedString = string;
    }

    boolean matches(String string) {
        return storedString.endsWith(string);
    }
}