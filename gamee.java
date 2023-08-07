import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class gamee {
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String characters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    String numbers = "1234567890";
    int lengthOfPassword;
    Random random = new Random();
    static ArrayList<Character> password = new ArrayList<>();



    public void createPassword(boolean isAlphabet, boolean isCharacters, boolean isNumbers, int passlength) {
        int remainingLength = passlength;
        
        if (isAlphabet) {
            int amount = random.nextInt(remainingLength) + 1;
            for (int i = 0; i < amount; i++) {
                int max = alphabet.length();
                int index = random.nextInt(max);
                char letter = alphabet.charAt(index);
                password.add(letter);
                remainingLength--;
            }
        }

        if (isCharacters) {
            int amount = random.nextInt(remainingLength) + 1;
            for (int i = 0; i < amount; i++) {
                int max = characters.length();
                int index = random.nextInt(max);
                char character = characters.charAt(index);
                password.add(character);
                remainingLength--;
            }
        }

        if (isNumbers) {
            int amount = random.nextInt(remainingLength) + 1;
            for (int i = 0; i < amount; i++) {
                int max = numbers.length();
                int index = random.nextInt(max);
                char number = numbers.charAt(index);
                password.add(number);
                remainingLength--;
            }
        }
    }

    private static String getPasswordAsString(ArrayList<Character> passwordArray) {
        ArrayList<Character> password = new ArrayList<Character>(passwordArray);
        StringBuilder sb = new StringBuilder();
        for (char c : password) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        boolean mainRepeat = true;
    while (mainRepeat == true) {
        boolean isAlphabet = false, isCharacters = false, isNumbers = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choices: ");
        System.out.println("- 1: create new password");
        System.out.println("- 2: view passwords");

        String actionChoice = scanner.nextLine();



        if (actionChoice.equals("1")) {
            System.out.print("How long should the password be?");
            int passlength = scanner.nextInt();

            System.out.println("Choices:");
            System.out.println("- 1: alphabet");
            System.out.println("- 2: special characters");
            System.out.println("- 3: numbers");
            System.out.println("- 4: break");

            while (true) {
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        isAlphabet = true;
                        break;
                    case "2":
                        isCharacters = true;
                        break;
                    case "3": 
                        isNumbers = true;
                        break;
                    default:
                        System.out.println("Please input a valid option number.");
                        break;
                    case "4":
                        break;
                }

                if (choice.equals("4")) {
                    break;
                }
            }

            if (isAlphabet || isCharacters || isNumbers) {
                gamee game = new gamee();
                game.lengthOfPassword = 10; // Set the password length to 10, change as needed
                game.createPassword(isAlphabet, isCharacters, isNumbers, passlength);
                String generatedPassword = gamee.getPasswordAsString(gamee.password);
                System.out.println("Your generated password is: " + generatedPassword);
            } else {
                System.out.println("No options selected. Exiting the program.");
            }
        } else if (actionChoice.equals("2")) {
            System.out.println("Password: " + getPasswordAsString(password));
        } else if (actionChoice.equals("3")) {
            mainRepeat = false;
            break;
        }     
        else {
            System.out.println("Invalid choice. try again.");
        }
    }
}
}