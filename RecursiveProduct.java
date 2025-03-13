package module5;

import java.util.Scanner;

public class RecursiveProduct {

    // This is the recursive method to calculate the product of numbers
    public static double productOfNumbers(double[] numbers, int index) {
        // The base case: if we have processed all numbers, return 1
        if (index == numbers.length) {
            return 1;
        }
        // The recursive case: multiply the current number and call the function with the next index
        return numbers[index] * productOfNumbers(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[5];

        // Prompt and obtain five numbers from the user
        System.out.println("Please enter five numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            while (true) {
                try {
                    numbers[i] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }

        // Calculate the product using the recursive method
        double productResult = productOfNumbers(numbers, 0);
        System.out.println("The product of the entered numbers is: " + productResult);

        scanner.close();
    }
}