import java.util.Random;
import java.util.Scanner;

/**
 * Класс "PasswordGenerator" генерирует случайные пароли.
 */

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("enter the lenght of password: ");
        int length = input.nextInt();

        System.out.print("add lowercase letters? (yes/no): ");
        char includeLower = input.next().charAt(0);

        System.out.print("add uppercase letters? (yes/no): ");
        char includeUpper = input.next().charAt(0);

        System.out.print("add numbers? (yes/no): ");
        char includeNumbers = input.next().charAt(0);

        System.out.print("add symbols? (yes/no): ");
        char includeSymbols = input.next().charAt(0);

        String password = generatePassword(length, includeLower, includeUpper, includeNumbers, includeSymbols, random);

        if (password.isEmpty()) {
            System.out.println("You must select at least one character type.");
        } else {
            System.out.println("Generated password: " + password);
        }
    }
    /**
     *  length   Желаемая длина пароля.
     * includeLower  'yes' для добавления строчных букв, 'no' иначе.
     *  includeUpper  'yes' для добавления прописных букв, 'no' иначе.
     *  includeNumbers 'yes' для добавления цифр, 'no' иначе.
     *  includeSymbols 'yes' для добавления символов, 'no' иначе.
     *  random      Генератор случайных чисел.
     */

    public static String generatePassword(int length, char includeLower, char includeUpper, char includeNumbers, char includeSymbols, Random random) {
        String lowercaseChars = "qwertyuiopasdfghjklzxcvbnm";
        String uppercaseChars = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String numberChars = "0123456789";
        String symbolChars = "!@#$%^&*()_+=-/?<>;:";

        String allowedChars = "";
        if (includeLower == 'y') allowedChars += lowercaseChars;
        if (includeUpper == 'y') allowedChars += uppercaseChars;
        if (includeNumbers == 'y') allowedChars += numberChars;
        if (includeSymbols == 'y') allowedChars += symbolChars;

        if (allowedChars.isEmpty()) {
            return "";
        }

        String password = "";
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password += allowedChars.charAt(randomIndex);
        }

        return password;
    }
}