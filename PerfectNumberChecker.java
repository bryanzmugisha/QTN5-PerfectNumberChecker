import java.util.Scanner;

public class PerfectNumberChecker {

    // (ii) Calculate sum of proper divisors
    public static int sumOfDivisors(int n) {
        int sum = 1; // 1 is always a proper divisor for n > 1
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) { // avoid adding square root twice
                    sum += n / i;
                }
            }
        }
        return (n == 1) ? 0 : sum; // proper divisors of 1 is 0
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        // (i) Input validation using exception handling
        while (true) {
            System.out.print("Enter a positive integer: ");
            try {
                String input = scanner.nextLine().trim();
                number = Integer.parseInt(input);
                if (number <= 0) {
                    throw new IllegalArgumentException("Number must be positive.");
                }
                break; // valid input, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. " + e.getMessage());
            }
        }

        // (ii) Calculate sum of proper divisors
        int divisorSum = sumOfDivisors(number);
        System.out.println("Sum of proper divisors of " + number + " = " + divisorSum);

        // (iii) Determine and display result
        if (divisorSum == number) {
            System.out.println(number + " IS a perfect number.");
        } else {
            System.out.println(number + " is NOT a perfect number.");
        }

        scanner.close();
    }
}
