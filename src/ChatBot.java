package ChatBot;

import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {

        String botname = "KastrulaBot";

        System.out.println("Hi! My name is " + botname + ".");
        System.out.println("i was born" + 2023 + ".");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Say your name.");
        String userName = scanner.nextLine();
        System.out.println("Nice name, " + userName + "!");
        System.out.println("let me calculate ur age.");
        System.out.println("Enter the remainders from dividing your age by 3, 5 і 7.");
        int number3 = scanner.nextInt();
        int number5 = scanner.nextInt();
        int number7 = scanner.nextInt();
        int userAge = (number3 * 70 + number5 * 21 + number7 * 15) % 105;
        System.out.println("your age is - " + userAge + "; this is a good time to think about your life!");
        System.out.println("Now i'll show u how can i calculate to any number!");
        int userNumber = scanner.nextInt();
        for (int i = 1; i <= userNumber; i++) {
            System.out.println(i + " !");
        }
        System.out.println("let's check ur brain.");
        System.out.println("What 2 + 2 is?");
        System.out.println("1. Apple.");
        System.out.println("2. Lol.");
        System.out.println("3. 4.");
        System.out.println("4. I don't know.");

        int correctAnswer = 3;
        int userAnswer;

        do {
            userAnswer = scanner.nextInt();

            if (userAnswer != correctAnswer) {
                System.out.println("Nah. Try again.");
            }
        } while (userAnswer != correctAnswer);

        System.out.println("Congratulation, You are smart.");
        System.out.println("Bye!");
    }
}