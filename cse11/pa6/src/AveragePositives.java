public class AveragePositives {

    public static void main(String[] args) {
        double average = 0;
        double count = 0;
        double currentNum;

        for (String stringNum : args) {
            currentNum = Double.parseDouble(stringNum);
            if (currentNum > 0) {
                average += currentNum;
                count++;
            }
        }

        if (count != 0) {
            average /= count;
        }

        System.out.println(average);
    }
}
