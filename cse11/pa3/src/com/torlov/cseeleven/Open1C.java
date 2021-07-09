public class Open1C {
    static String doubleLength(String words) {
        return words + words;
    }

    static String halveLength(String words) {
        return words.substring(0, words.length() / 2);
    }

    public static void main(String args[]) {
        String helloWorld = "Hello World!";
        System.out.println("Doubling the string \"hello\":");
        System.out.println(doubleLength(helloWorld));
        System.out.println("Halving the string \"hello\":");
        System.out.println(halveLength(helloWorld));
    }
}
