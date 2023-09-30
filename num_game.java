/*
 TASK 1
1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guessis correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.
You can incorporate additional details as follows:
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 */
import java.util.Scanner;

class num_game {
    static int num; //we store our random integer from 1 to 100 in this variable
    static int score = 0; // stores the score of the player

    public static int numgen() {
        // Generate a random number between 1 and 100 only once
        num = (int) (Math.random() * 100) + 1; 
        return num;
    }

    public static void guess(int limits) {
        numgen(); // we call the numgen() function here to ensure that only once the number is generated and user gets 5 tries to guess it.
        int count = 0; // count stores the number of tries of the player. As it hits 5 the player exhausts his limit 

        while (count < limits) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your guess between 1 and 100:");
            System.out.println(num);
            int guess = in.nextInt();
            // player enters his/her guess

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a valid guess between 1 and 100.");
                continue;
                // ensures the number is between 1 and 100
            }

            if (guess == num) {
                System.out.println("YOU WIN");
                score++;
                break;
                // this part is responsible for correct guess 
            } else if (guess < num) {
                System.out.println("Try again. Your guess was too low.");
            } else {
                System.out.println("Try again. Your guess was too high.");
            }

            count++;
            //Compares if the player input is less than or greater than to the random number generated and takes decision accordingly
            in.close();
        }

        if (count == limits) {
            System.out.println("You exhausted your limits. The correct number was: " + num);
        }
        // This part gets executed if the user has exhausted his limits, that is 5 in this program.

        System.out.println("Your score: " + score);
        
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the number guessing game");

        char play_reply; 
        do {
            int limits = 5; // Number of attempts per round
            System.out.println("Do you want to play a round? (y/n)");
            char ready = sc.nextLine().charAt(0); // we take only  y or n irrrespactive on any string with the charAt(0) function

            if (ready == 'Y' || ready == 'y') {
                guess(limits);

                System.out.println("Play another round? (y/n)");
                play_reply = sc.nextLine().charAt(0);
            } else {
                System.out.println("Your cancel request was successful");
                play_reply = 'n'; // Exit the game
            }
        } while (play_reply == 'Y' || play_reply == 'y');

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
