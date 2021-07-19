import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StringSearch {
    public static void main(String args[]) throws Exception {
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println(args[0] + " does not exist");
            System.exit(0);
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String fileText;
        while ((fileText = bufferedReader.readLine()) != null) {
            System.out.println(fileText);
        }
    }
}