package RockPaperScissorsGame;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] rps = {"R", "P", "S"};
        String computerChoice = rps[new Random().nextInt(rps.length)];

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your move: (r, p, or s)");
            String move = scanner.nextLine();

            switch (move) {
                case "r": computerChoice = "r";
                System.out.println("It's a tie!");
                break;
                case "p": computerChoice = "r"; System.out.println("You win!"); break;
                case "s": computerChoice = "r"; System.out.println("You loose!"); break;
                default: System.out.println("Please enter your move: (r, p, or s)");break;


            }

            switch (move) {
                case "r": computerChoice = "p";
                    System.out.println("You loose!");
                    break;
                case "p": computerChoice = "p"; System.out.println("It's a tie!"); break;
                case "s": computerChoice = "p"; System.out.println("You win!"); break;
                default: System.out.println("Please enter your move: (r, p, or s)");break;
            }


            switch (move) {
                case "r": computerChoice = "s";
                    System.out.println("You win");
                    break;
                case "p": computerChoice = "s"; System.out.println("You loose!"); break;
                case "s": computerChoice = "s"; System.out.println("It's a tie!"); break;
                default: System.out.println("Please enter your move: (r, p, or s)");break;
            }
//            if (move.equals("r") || move.equals("p") || move.equals("s")) {
//                break;
//            }
//            System.out.println("Computer played: " + computerChoice);

//            if (move.equals("r") {
//                System.out.println("Computer played: " + computerChoice);
//            }

        }

    }


}
