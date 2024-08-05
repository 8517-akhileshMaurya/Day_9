

public class MainApp {

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            double result = DivisionProcessor.calculate(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            // Provide user-friendly message here (e.g., "Oops! Something went wrong.")
        }
    }
}


