import java.util.Scanner;
public class RPC {
    public static final int BAD_ROCK = -1;
    public static final int BAD_PAPER = -2;
    public static final int BAD_CROSSBLADES = -3;
    public static final int DISQUALIFIED = 0;
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int CROSSBLADES = 3;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Human, let’s have an epic game of Rock, Paper, Crossblades!!!");
        System.out.print("Your response: ");
        String response = input.nextLine();
        response = response.toLowerCase();
        System.out.println();
        evaluate(getChoice(response));
    }
    
    public static int getChoice(String r) {
        int answer = 0;
        if (r.length() >= 4 && r.lastIndexOf("rock") == r.length() - 4) 
        {
            answer = ROCK;
        }
        if (r.length() >= 5 && r.lastIndexOf("paper") == r.length() - 5) 
        {
            answer = PAPER;
        }
        if (r.length() >= 11 && r.lastIndexOf("crossblades") == r.length() - 11) 
        { 
            answer = CROSSBLADES;
        }
        if (r.length() < 50) {
            answer *= -1;
        }
        
        return answer;
    }
    
    public static void evaluate(int choice) {
        if (choice == DISQUALIFIED) {
            System.out.println("Me: You have failed to adhere to the ancient traditions of Rock, Paper, Crossblades! You have lost by disqualification! Disgraceful!\n\n"
            + "Result: As I predicted, I have won this battle. The kingdom is MINE!");
        } else if (choice < 0) {
            String computer_choice = autoL(choice*-1);
            System.out.println("Me: Pathetic. You cannot hope to beat me without the passion of a thousand suns, without the dedication of a Pleistocene glacier! I choose " + computer_choice
                + "! \n\nResult: As I predicted, I have won this battle. The kingdom is MINE!");
        } else {
            int computer_choice = (int)(Math.random()*3)+1;
            System.out.println("Me: Does he know my strategy? Two stones in a row... what are the chances? Did he steal my notes? Did he follow me into the archives? No, stay the course: " 
            + StringName(computer_choice));
            getFinalResult(computer_choice, choice);
        }
    }
    
    public static String StringName(int choice) {
        String[] words = {"Rock", "Paper", "Crossblades"};
        return words[choice-1];
    }
    
    
    public static String autoL (int choice) {
        if (choice == ROCK) return "PAPER";
        else if (choice == PAPER) return "CROSSBLADES";
        else return "ROCK";
    }
    
    public static void getFinalResult(int computer, int human) {
        System.out.print("\nResult: ");
        if (computer == human) {
            System.out.println("Unbelievable! We have tied! *Eye twitches*");
        } else if (computer == ROCK && human == PAPER
        || computer == PAPER && human == CROSSBLADES
        || computer == CROSSBLADES && human == ROCK) {
            System.out.println("Nooooo!!! How could you beat me?! (You win!)");
        } else {
            System.out.println("I have won this battle. The kingdom is MINE! (You lost!)");
        }
    }
}
