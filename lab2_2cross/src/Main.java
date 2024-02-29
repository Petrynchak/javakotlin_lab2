import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Функція для розв'язування алгебраїчної нерівності та визначення проміжків, де нерівність виконується
    public static ArrayList<Double> solveInequality(double a, double b, double c) {
        ArrayList<Double> intervals = new ArrayList<>(); // Створюємо список для збереження проміжків

        // Перевіряємо особливі випадки
        if (a == 0 && c == 0) {
            if (b > 0) { // Якщо b > 0, то нерівність виконується для будь-якого x, тому весь ряд від'ємно нескінченний і додатно нескінченний є розв'язком
                intervals.add(Double.NEGATIVE_INFINITY);
                intervals.add(Double.POSITIVE_INFINITY);
            }
        } else if (a == 0) {
            if (b / c > 0) { // Якщо b/c > 0, то нерівність виконується для будь-якого x > -c, тому розв'язок -c і додатно нескінченний
                intervals.add(Double.NEGATIVE_INFINITY);
                intervals.add(-c);
                intervals.add(Double.POSITIVE_INFINITY);
            }
        } else if (c == 0) {
            if (a > 0) { // Якщо a > 0, то нерівність виконується для будь-якого x < b/a, тому розв'язок від'ємно нескінченний і b/a
                intervals.add(Double.NEGATIVE_INFINITY);
                intervals.add(b / a);
                intervals.add(Double.POSITIVE_INFINITY);
            }
        } else {
            double discriminant = a * a - 4 * c * b; // Обчислюємо дискримінант
            if (discriminant > 0) {
                double root1 = (-a + Math.sqrt(discriminant)) / (2 * c); // Обчислюємо перший корінь
                double root2 = (-a - Math.sqrt(discriminant)) / (2 * c); // Обчислюємо другий корінь
                if (root1 < root2) { // Додаємо проміжки від'ємно нескінченний - root1, root1 - root2, root2 - додатно нескінченний
                    intervals.add(Double.NEGATIVE_INFINITY);
                    intervals.add(root1);
                    intervals.add(root2);
                    intervals.add(Double.POSITIVE_INFINITY);
                } else {
                    intervals.add(Double.NEGATIVE_INFINITY);
                    intervals.add(root2);
                    intervals.add(root1);
                    intervals.add(Double.POSITIVE_INFINITY);
                }
            } else if (discriminant == 0) {
                double root = -a / (2 * c); // Обчислюємо єдиний корінь
                if (root > 0) { // Якщо корінь додатній, то додаємо проміжки від'ємно нескінченний - root та root - додатно нескінченний
                    intervals.add(Double.NEGATIVE_INFINITY);
                    intervals.add(root);
                    intervals.add(Double.POSITIVE_INFINITY);
                } else { // Інакше розв'язок буде від'ємно нескінченний та додатно нескінченний
                    intervals.add(Double.NEGATIVE_INFINITY);
                    intervals.add(Double.POSITIVE_INFINITY);
                }
            } else { // Якщо дискримінант від'ємний, то нерівність не має розв'язків
                intervals.add(Double.NEGATIVE_INFINITY);
                intervals.add(Double.POSITIVE_INFINITY);
            }
        }

        return intervals; // Повертаємо список проміжків
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо коефіцієнти з клавіатури
        System.out.println("Enter the coefficient a:");
        double a = scanner.nextDouble();

        System.out.println("Enter the coefficient b:");
        double b = scanner.nextDouble();

        System.out.println("Enter the coefficient c:");
        double c = scanner.nextDouble();

        // Визначаємо проміжки, де нерівність виконується
        ArrayList<Double> intervals = solveInequality(a, b, c);

        // Виводимо результат
        System.out.println("Solution intervals:");
        for (int i = 0; i < intervals.size() - 1; i += 2) {
            System.out.println("(" + intervals.get(i) + ", " + intervals.get(i + 1) + ")");
        }
    }
}
