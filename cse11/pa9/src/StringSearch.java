import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StringSearch {
    final static String[] queryTokens = {"not","length","greater","less","contains","starts","end", "word"};

    public static void main (String[] args) throws Exception {
        List<String> fileText = getFileText(args[0]);

        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            if (isArgQuery(arg)) {
                List<Query> queries = parseStringIntoQueries(arg);
                filterText(queries, fileText);
            }
            else {
                List<Transformations> transformations = parseStringIntoTransformations(arg);
                transformText(transformations, fileText);
            }
        }

        outputText(fileText);
    }

    static List<String> getFileText (String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println(filePath + " does not exist");
            System.exit(0);
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String fileTextString;
        List<String> fileText = new ArrayList<>();
        while ((fileTextString = bufferedReader.readLine()) != null) {
            fileText.add(fileTextString);
        }

        bufferedReader.close();

        return fileText;
    }

    static List<Query> parseStringIntoQueries (String queryString) {
        List<Query> queries = new ArrayList<>();
        String[] allQueries = queryString.split("&");

        for (String generalQuery : allQueries) {
            String[] specificQuery = generalQuery.split("=");

            if (generalQuery.startsWith("not")) {
                String notQueryString = generalQuery.substring(4, generalQuery.length() - 1);
                List<Query> notQueries = parseStringIntoQueries(notQueryString);
                for (Query notQuery : notQueries) {
                    queries.add(new NotQuery(notQuery));
                }

                continue;
            }

            String queryType = specificQuery[0];
            String queryValue = specificQuery[1];

            switch (queryType) {
                case "length":
                    int matchLength = Integer.parseInt(queryValue);
                    queries.add(new MatchLengthQuery(matchLength));
                    break;

                case "greater":
                    int greaterThanLength = Integer.parseInt(queryValue);
                    queries.add(new GreaterLengthQuery(greaterThanLength));
                    break;

                case "less":
                    int lessThanLength = Integer.parseInt(queryValue);
                    queries.add(new LesserLengthQuery(lessThanLength));
                    break;

                case "contains":
                    String containString = queryValue.replaceAll("'", "");
                    queries.add(new ContainsStringQuery(containString));
                    break;

                case "starts":
                    String startsWithString = queryValue.replaceAll("'", "");
                    queries.add(new StartsWithQuery(startsWithString));
                    break;

                case "ends":
                    String endsWithString = queryValue.replaceAll("'", "");
                    queries.add(new EndsWithQuery(endsWithString));
                    break;

                case "word":
                    String matchesWordString = queryValue.replaceAll("'", "");
                    queries.add(new MatchesWordQuery(matchesWordString));
                    break;
            }
        }

        return queries;
    }

    static void filterText (List<Query> queries, List<String> fileText) {
        for (Query query : queries) {
            fileText.removeIf(fileLine -> !query.matches(fileLine));
        }
    }

    static List<Transformations> parseStringIntoTransformations (String transformationString) {
        List<Transformations> transformations = new ArrayList<>();
        String[] allTransformations = transformationString.split("&");

        for (String generalTransformation : allTransformations) {
            String[] specificTransformation = generalTransformation.split("=");

            String transformationType = specificTransformation[0];
            String transformationValue = "";
            if (specificTransformation.length > 1) {
                transformationValue = specificTransformation[1];
            }

            switch (transformationType) {
                case "upper":
                    transformations.add(new UpperCaseTransformation());
                    break;

                case "lower":
                    transformations.add(new LowerCaseTransformation());
                    break;

                case "first":
                    int beginningLength = Integer.parseInt(transformationValue);
                    transformations.add(new GetBeginningTransformation(beginningLength));
                    break;

                case "last":
                    int endingLength = Integer.parseInt(transformationValue);
                    transformations.add(new GetEndingTransformation(endingLength));
                    break;

                case "replace":
                    String[] replacementValues = transformationValue.split("';'");
                    String toReplace = replacementValues[0].substring(1);
                    String replacement = replacementValues[1].substring(0, replacementValues[1].length() - 1);

                    transformations.add(new ReplaceTransformation(toReplace, replacement));
                    break;

                case "range":
                    String[] rangeValues = transformationValue.split(",");
                    int beginIndex = Integer.parseInt(rangeValues[0]);
                    int endIndex = Integer.parseInt(rangeValues[1]);

                    transformations.add(new RangeTransformation(beginIndex, endIndex));
                    break;
            }
        }

        return transformations;
    }

    static void transformText (List<Transformations> transformations, List<String> fileText) {
        for (Transformations transformation : transformations) {
            for (int i = 0; i < fileText.size(); i++) {
                String line = fileText.get(i);
                line = transformation.transform(line);
                fileText.set(i, line);
            }
        }
    }

    static void outputText (List<String> fileText) {
        for (String string : fileText) {
            System.out.println(string);
        }
    }

    static boolean isArgQuery (String arg) {
        for (String token : queryTokens) {
            if (arg.startsWith(token)) {
                return true;
            }
        }

        return false;
    }
}

