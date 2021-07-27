import java.util.ArrayList;
import java.util.Locale;

public interface Transformations {
    String transform(String line);
}

class UpperCaseTransformation implements Transformations {
    public String transform (String line) {
        return line.toUpperCase();
    }
}

class LowerCaseTransformation implements Transformations {
    public String transform (String line) {
        return line.toLowerCase();
    }
}

class GetBeginningTransformation implements Transformations {
    int length;

    GetBeginningTransformation (int length) {
        this.length = length;
    }

    public String transform (String line) {
        if (line.length() < this.length) {
            return line;
        }

        return line.substring(0, this.length);
    }
}

class GetEndingTransformation implements Transformations {
    int length;

    GetEndingTransformation (int length) {
        this.length = length;
    }

    public String transform (String line) {
        if (line.length() < this.length) {
            return line;
        }

        return line.substring(line.length() - this.length);
    }
}

class ReplaceTransformation implements Transformations {
    String toReplace;
    String replacement;

    ReplaceTransformation (String toReplace, String replacement) {
        this.toReplace = toReplace;
        this.replacement = replacement;
    }

    public String transform (String line) {
        return line.replaceAll(toReplace, replacement);
    }
}

class RangeTransformation implements Transformations {
    int beginIndex;
    int endIndex;

    RangeTransformation (int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;

    }

    public String transform (String line) {
        if (!(line.length() < endIndex)) {
            line = line.substring(0, endIndex);
        }

        if (line.length() < beginIndex) {
            return "";
        }

        line = line.substring(beginIndex);
        return line;
    }
}