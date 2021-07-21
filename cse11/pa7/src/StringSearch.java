import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StringSearch {
    public static void main(String args[]) throws Exception {
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println(args[0] + " does not exist");
            System.exit(0);
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String fileTextString;
        List<String> fileText = new ArrayList<>();
        while ((fileTextString = bufferedReader.readLine()) != null) {
            fileText.add(fileTextString);
        }

        bufferedReader.close();
        List<Query> queries = new ArrayList<>();
        String[] allQueries = args[1].split("&");

        for (String generalQuery : allQueries) {
            String[] specificQuery = generalQuery.split("=");

            System.out.println(specificQuery[0]);
            System.out.println(specificQuery[1]);

            if (generalQuery.startsWith("not")) {

                continue;
            }

            switch (specificQuery[0]) {
                case "length":
                    queries.add(new matchLengthQuery(Integer.parseInt(specificQuery[1])));
                    fileText = queries.matchLength(fileText, Integer.parseInt(specificQuery[1]));
                    break;

                case "greater":
                    queries.add(new greaterLengthQuery(Integer.parseInt(specificQuery[1])));
                    fileText = queries.greaterLength(fileText, Integer.parseInt(specificQuery[1]));
                    break;

                case "less":
                    queries.add(new lesserLengthQuery(Integer.parseInt(specificQuery[1])));
                    fileText = queries.lessLength(fileText, Integer.parseInt(specificQuery[1]));
                    break;

                case "contains":
                    queries.add(new containsString(specificQuery[1]));
                    fileText = queries.containsString(fileText, specificQuery[1]);
                    break;

                case "starts":
                    queries.add(new containsString(specificQuery[1]));
                    fileText = queries.startsWith(fileText, specificQuery[1]);
                    break;

                case "ends":
                    queries.add(new containsString(specificQuery[1]));
                    fileText = queries.endWith(fileText, specificQuery[1]);
                    break;
            }
        }

        for (Query query : queries) {
            for (String fileLine : fileText) {

            }
        }

        for (String string : fileText) {
            System.out.println(string);
        }
    }
}