import java.util.Random;
import java.util.Scanner;

public class NumberGuessgame {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static boolean isInputWithinRange(String input) {
        if (input == null || !input.matches("\\d+")) {
            return false;
        }
        try {
            int value = Integer.parseInt(input);
            return value >= RANGE_MIN && value <= RANGE_MAX;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String requestInput(String message) {
        System.out.print(message);
        return INPUT_READER.nextLine();
    }

    public static String analyzeGuess(int guess, int target) {
        if (guess < target) {
            return "Too low! Try a higher number: ";
        } else if (guess > target) {
            return "Too high! Try a lower number: ";
        }
        return null;
    }

    public static void main(String[] args) {
        final int targetValue = new Random().nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
        boolean hasWon = false;
        int totalAttempts = 0;

        String rawInput = requestInput(String.format("Guess a number between %d and %d: ", RANGE_MIN, RANGE_MAX));

        while (!hasWon) {
            if (!isInputWithinRange(rawInput)) {
                rawInput = requestInput(String.format("Invalid entry. Please enter a digit from %d to %d: ", RANGE_MIN, RANGE_MAX));
                continue;
            }

            totalAttempts++;
            int currentGuess = Integer.parseInt(rawInput);
            String feedback = analyzeGuess(currentGuess, targetValue);

            if (feedback != null) {
                rawInput = requestInput(feedback);
            } else {
                System.out.println("Congratulations! You found it in " + totalAttempts + " tries.");
                hasWon = true;
            }
        }

        INPUT_READER.close();
    }
}