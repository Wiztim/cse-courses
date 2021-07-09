public class Drill4 {
    public static void main(String args[]) {
        System.out.println("Testing phaseOfWater with input of 111, output should be \"vapor\")");
        System.out.println(phaseOfWater(111));
        System.out.println("Testing phaseOfWater with input of 0, output should be \"solid\")");
        System.out.println(phaseOfWater(0));
        System.out.println("Testing phaseOfWater with input of 1, output should be \"liquid\")");
        System.out.println(phaseOfWater(1));

        System.out.println("Testing maxDifference with input of 1, 2, 3, output should be 2)");
        System.out.println(maxDifference(1, 2, 3));
        System.out.println("Testing maxDifference with input of 0, 3, 3, output should be 3)");
        System.out.println(maxDifference(0, 3, 3));
        System.out.println("Testing maxDifference with input of 1, 1, 1, output should be 0)");
        System.out.println(maxDifference(1, 1, 1));

        System.out.println("Testing ringArea with input of 5 and 10, output should be 235.619)");
        System.out.println(ringArea(5, 10));
        System.out.println("Testing ringArea with input of 12 and 12, output should be 0)");
        System.out.println(ringArea(12, 12));
        System.out.println("Testing ringArea with input of 11 and 23, output should be 1281.77)");
        System.out.println(ringArea(11, 23));
    }

    public static String phaseOfWater(int temp) {
        if (temp >= 100) {
            return "vapor";
        }

        else if (temp <= 0) {
            return "solid";
        }

        return "liquid";
    }

    public static int maxDifference(int first, int second, int third) {
        int max = Math.max(first, Math.max(second, third));
        int min = Math.min(first, Math.min(second, third));
        return max - min;
    }

    public static double ringArea(double innerRadius, double outerRadius) {
        double innerArea = Math.pow(innerRadius, 2);
        double outArea = Math.pow(outerRadius, 2);
        return Math.PI * (outArea - innerArea);
    }
}
