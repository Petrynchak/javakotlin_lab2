import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо два цілі числа з консолі
        System.out.print("Enter the first integer: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int secondNumber = scanner.nextInt();

        // Обчислюємо суму, різницю та добуток
        int sum = firstNumber + secondNumber;
        int difference = Math.abs(firstNumber - secondNumber);
        int product = firstNumber * secondNumber;

        System.out.println("sum = " + sum);
        System.out.println("difference = " + difference);
        System.out.println("product = " + product);

        // Визначаємо найбільше значення серед суми, різниці та добутку
        int max = Math.max(Math.max(sum, difference), product);

        System.out.println("The maximum value among the sum, difference, and product is: " + max);
    }
}
