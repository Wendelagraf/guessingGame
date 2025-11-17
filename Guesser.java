import java.util.Scanner;

public class Guesser {
    private int low;
    private int high;

    public Guesser(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public void start() {
        rules();
        doGuesses();
    }

    private void rules() {
        System.out.println("Think of a number between " + low + " and " + high);
        System.out.println("I'm going to ask a few questions in order to guess the number.");
        System.out.println("Please answer T for true, and F for false.\n");
    }

    private String getReply() {
        Scanner scanner = new Scanner(System.in);
        String reply;
        while (true) {
            reply = scanner.nextLine().trim();
            if ("T".equalsIgnoreCase(reply) || "F".equalsIgnoreCase(reply)) {
                return reply.toUpperCase();
            }
            System.out.println("Please reply T for true or F for false");
        }
    }

    private void doGuesses() {
        int i = 0;
        int middle = 0;
        int currentLow = low;
        int currentHigh = high;

        while (currentLow < currentHigh) {
            middle = currentLow + (currentHigh - currentLow) / 2;

            System.out.println("Is the number less than or equal to " + middle + "?");
            String reply = getReply();

            if ("T".equals(reply)) {
                currentHigh = middle;
            } else {
                currentLow = middle + 1;
            }

            i++;
        }

        answer(currentLow, i);
    }

    private void answer(int guess, int numberOfGuesses) {
        System.out.println("You were thinking about " + guess + " (took me " + numberOfGuesses + " guesses)");
    }
}

