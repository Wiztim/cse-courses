import java.util.List;

public class Queries {
    // matches text lines if they have the same length
    List<String> matchLength(List<String> fileText, int length) {
        return fileText.stream().filter(string -> string.length() == length).toList();
    }

    // matches text lines if they are longer than the int
    List<String> greaterLength(List<String> fileText, int length) {
        return fileText.stream().filter(string -> string.length() > length).toList();
    }

    // matches text lines if they are shorter than the int
    List<String> lessLength(List<String> fileText, int length) {
        return fileText.stream().filter(string -> string.length() < length).toList();
    }

    // matches text lines if they contain the string
    List<String> containsString(List<String> fileText, String matchToString) {
        return fileText.stream().filter(string -> string.contains(matchToString)).toList();
    }

    // matches lines starting with the provided string
    List<String> startsWith(List<String> fileText, String matchToString) {
        return fileText.stream().filter(string -> string.startsWith(matchToString)).toList();
    }

    // matches lines ending with the provided string
    List<String> endWith(List<String> fileText, String matchToString) {
        return fileText.stream().filter(string -> string.endsWith(matchToString)).toList();
    }
}
