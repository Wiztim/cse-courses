public class Stats {

    public static void main(String args[]) {
        double results;

        switch(args[0]) {
            case "--product":
                results = 1;
                for (int i = 1; i < args.length; i++) {
                    results *= Double.parseDouble(args[i]);
                }

                System.out.println(results);
                break;

            case "--mean":
                results = 0;
                for (int i = 1; i < args.length; i++) {
                    results += Double.parseDouble(args[i]);
                }

                results /= args.length - 1;
                System.out.println(results);
                break;

            case "--total":
                results = 0;
                for (int i = 1; i < args.length; i++) {
                    results += Double.parseDouble(args[i]);
                }

                System.out.println(results);
                break;

            case "--max":
                results = Double.parseDouble(args[1]);

                for (int i = 1; i < args.length; i++) {
                    if(results < Double.parseDouble(args[i])) {
                        results = Double.parseDouble(args[i]);
                    };
                }

                System.out.println(results);
                break;

            case "--min":
                results = Double.parseDouble(args[1]);

                for (int i = 1; i < args.length; i++) {
                    if(results > Double.parseDouble(args[i])) {
                        results = Double.parseDouble(args[i]);
                    };
                }

                System.out.println(results);
                break;

            default:
                System.out.println("Bad option");
                System.out.println(args[0]);
                break;
        }
    }
}
