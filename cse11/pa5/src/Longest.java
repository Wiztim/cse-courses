public class Longest {
    public static void main(String args[]) {
        int longString = 0;
        for (int i = 0; i < args.length; i++) {
            if(args[longString].length() < args[i].length()) {
                longString = i;
            }
        }

        if (args.length == 0) {
            System.out.println();
        }
        else {
            System.out.println(args[longString]);
        }
    }
}