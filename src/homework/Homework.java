package homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1
         System.out.print("task 1:\nEnter size array: ");
         int n = scanner.nextInt();
         drawArray(n);

        //2
          System.out.println("\ntask 2:\nGuess number");
          guessNumber();

        //3
        System.out.println("\ntask 3:\nGuess word");
        guessWord();

        scanner.close();
    }

    //1. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void drawArray(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array.length - 1 - i) array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //2. Написать программу, которая загадывает случайное число от 0 до 9
    // и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
    // больше ли указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    // выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    public static void guessNumber() {
        Random random = new Random();
        int number;
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            number = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.println(i + 1 + " try: ");
                n = scanner.nextInt();
                if (n == number) {
                    System.out.println("You win!");
                    break;
                } else if (n > number) {
                    System.out.println("Number is less.");
                } else {
                    System.out.println("Number is greater.");
                }
                if (i == 2) {
                    System.out.println("You lose! Correct number was " + number);
                }
            }
            System.out.println("Do you wanna play the game one more time? 1 – yes / 0 – no");
        } while (scanner.nextInt() == 1);
    }

    //3. **Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
    // "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
    // "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано,
    // компьютер показывает буквы, которые стоят на своих местах. apple – загаданное apricot -
    // ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    // Для сравнения двух слов посимвольно можно пользоваться: String str = "apple";
    // char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    // Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.

    public static void guessWord() {
        String[] arrayWords = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[] correctLetters = new char[15];
        String wordU;
        do {
            String word = arrayWords[random.nextInt(arrayWords.length)];
            System.out.println(Arrays.toString(arrayWords));
            do {
                Arrays.fill(correctLetters, '#');
                System.out.print("Enter word: ");
                //System.out.println(word);
                wordU = scanner.next();
                if (wordU.equals(word)) {
                    System.out.println("You win!");
                    break;
                }
                for (int i = 0; i < word.length() && i < wordU.length(); i++) {
                    if (word.charAt(i) == wordU.charAt(i)) {
                        correctLetters[i] = word.charAt(i);
                    }
                }
                System.out.println("Try again. Correct letters: " + new String(correctLetters));

            } while (true);
            System.out.println("Do you wanna play the game one more time? 1 – yes / 0 – no");
        } while (scanner.nextInt() == 1);
    }

}
