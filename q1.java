import java.util.Random;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Random random = new Random();
        int given = random.nextInt(100) + 1;
        System.out.println("You only have five attempts to guess");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in the range of 1 to 100 to guess the number: ");
        int guess = scanner.nextInt();
        func(guess, given);
        int i = 5;

        while (guess != given && i != 1) {
            i--;
            System.out.println(i + " attempts left");
            System.out.print("Enter another number: ");
            guess = scanner.nextInt();
            func(guess, given);
        }

        if (i == 1) {
            System.out.println("Your attempts are over :)\nDo you wanna play again?");
            System.out.print("Enter yes to play again: ");
            String answer = scanner.next();
            if (answer.equals("yes")) {
                start();
            }
        }
    }

    public static void func(int guess, int given) {
        if (guess > given) {
            System.out.println("Number entered is greater");
        }
        if (guess < given) {
            System.out.println("Number entered is smaller");
        }
        if (guess == given) {
            System.out.println("Correct");
        }
    }
}

