public class DesignRecipeExamples {

	public static void main(String[] args) {
		System.out.println("Calling perimeter with input of width 5 and length 10.");
		System.out.println("\""	+ perimeter(5, 10) + "\"");
		System.out.println("Calling perimeter with input of width 0 and length 10.");
		System.out.println("\""	+ perimeter(0, 10) + "\"");
		System.out.println("Calling perimeter with input of width 1 and length 2.");
		System.out.println("\""	+ perimeter(1, 2) + "\"");
		System.out.println();

		System.out.println("Calling borderArea with input of outerWidth 10, outerLength 20, innerWidth 5, and innerLength 10");
		System.out.println("\"" + borderArea(10, 20, 5, 10) + "\"");
		System.out.println("Calling borderArea with input of outerWidth 5, outerLength 10, innerWidth 5, and innerLength 20");
		System.out.println("\"" + borderArea(5, 10, 5, 20) + "\"");
		System.out.println("Calling borderArea with input of outerWidth 2, outerLength 20, innerWidth 2, and innerLength 10");
		System.out.println("\"" + borderArea(2, 20, 2, 10) + "\"");
		System.out.println();

		// converting 10 feet is off by 0.545 meters
                System.out.println("Calling feetToMeters with input of 51 feet\n\"" + feetToMeters(51) + "\"");
		// converting less than 4 feet results in 0 feet
                System.out.println("Calling feetToMeters with input of 3 feet\n\"" + feetToMeters(3) + "\"");
		//showing that 0 feet is still 0 meters
		System.out.println("Calling feetToMeters with input of 0 feet\n\"" + feetToMeters(0) + "\"");
		System.out.println();

		// off by 0.048 m
		System.out.println("calling addFeetToMeter with 10 feet and 10 meters\n\"" + addFeetToMeters(10, 10) + "\"");
		// off by 0.096 m
		System.out.println("calling addFeetToMeter with -20 feet and 13 meters\n\"" + addFeetToMeters(-20, 13) + "\"");
		// off by 0.04 m
		System.out.println("calling addFeetToMeter with 21 feet and -33 meters\n\"" + addFeetToMeters(21, -33) + "\"");
	}

	public static int perimeter(int width, int length) {
		if (width <= 0 || length <= 0) {
			System.out.println("Error: At least one dimension is too small.");
			return 0;
		}

		return 2 * width + 2 * length;
	}

	public static int borderArea(int outerWidth, int outerLength, int innerWidth, int innerLength) {
		if (outerWidth <= 0 || outerLength <= 0 || innerWidth < 0 || innerLength < 0) {
			System.out.println("Error: At least one dimension is too small.");
			return 0;
		}
		else if (innerWidth > outerWidth || innerLength > outerLength) {
			System.out.println("Error: The inner rectangle is larger than the outer.");
			return 0;
		}

		return outerWidth * outerLength - innerWidth * innerLength;
	}

	// this method will take one int parameter as feet
	// and convert it to meters
	public static int feetToMeters(int feet) {
		return (int) (feet / 3.2808);
	}

	// this will take the first parameter as feet
	// and add it to the second parameter in meters
	public static int addFeetToMeters(int feet, int meters) {
		return feetToMeters(feet) + meters;
	}
}
