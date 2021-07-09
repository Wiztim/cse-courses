public class Open1B {
    // showing that 2 variables can't have same names despite different types
    int numbers = 123;
    //String numbers = "123";

    public static void main(String args[]) {
        Open1B open1B = new Open1B();
        System.out.println("Here are some numbers: " + open1B.numbers);
        System.out.println("Here are some more numbers: " + open1B.numbers);
    }
}
