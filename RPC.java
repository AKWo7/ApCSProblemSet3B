import java.util.Scanner;
public class RPC {
    public static void main(String[] args){
        System.out.println("Computer: Let's play an epic game of Rock, Paper, Crossblades!");
        
        System.out.print("Player: ");
        Scanner scanner = new Scanner(System.in);
        String speech = scanner.nextLine();
        
        if (speech.length()<50 && (getLastWord(speech).equalsIgnoreCase("rock")||getLastWord(speech).equalsIgnoreCase("paper")||getLastWord(speech).equalsIgnoreCase("crossblades"))){
            System.out.print("Computer: Pathetic. You cannot hope to beat me without the passion of a thousand suns, without the dedication of a Pleistocene glacier! ");
            
            String compChoice = determineComputerChoice(speech);
            System.out.println(compChoice+"!");
            
            String result = determineResult(speech, compChoice);
            System.out.println("Result: The computer wins the kingdom!!!");
            
        }
        else if (!getLastWord(speech).equalsIgnoreCase("rock")&&!getLastWord(speech).equalsIgnoreCase("paper")&&!getLastWord(speech).equalsIgnoreCase("crossblades")){
            System.out.println("You have failed to adhere to the ancient traditions of Rock, Paper, Crossblades! You have lost by disqualification! Disgraceful!");
            System.out.println("Result: The computer wins the kingdom!!!");
        }
        else{
                String compChoice = getRandomChoice();
                String playerChoice = getLastWord(speech);
                System.out.println("Computer: Does he know my strategy? Two stones in a row... what are the chances? Did he steal my notes? Did he follow me into the archives? No, stay the course: " + compChoice+"!");
                
                String result = determineResult(playerChoice, compChoice);
                System.out.println("Result: "+ result);
            }
    }
    
    private static String determineComputerChoice(String speech){
        String lastWord = getLastWord(speech);
        
        if (lastWord.equalsIgnoreCase("rock")){
            return "Paper";
        }
        else if (lastWord.equalsIgnoreCase("paper")){
            return "Crossblades";
        }
        else if (lastWord.equalsIgnoreCase("crossblades")){
            return "Rock";
        }
        else{
            return "You have failed to adhere to the ancient traditions of Rock, Paper, Crossblades! You have lost by disqualification! Disgraceful!";
        }
    }
    
    private static String getLastWord(String speech){
        speech = speech.trim();
        int lastSpaceIndex = speech.lastIndexOf(' ');
        if (lastSpaceIndex != -1){
            return speech.substring(lastSpaceIndex+1);
        }
        else{
            return speech;
        }
    }
    
    private static String getRandomChoice(){
        int random = (int) (Math.random()*3);
        if (random == 0){
            return "Rock";
        }
        else if (random == 1){
            return "Paper";
        }
        else {
            return "Crossblades";
        }
    }
    
    private static String determineResult(String playerChoice, String compChoice){
        if(playerChoice.equalsIgnoreCase(compChoice)){
            return "Unbelievable! They have tied!";
        }
        else if ((playerChoice.equalsIgnoreCase("Rock") && compChoice.equalsIgnoreCase("Crossblades")||playerChoice.equalsIgnoreCase("Crossblades") && compChoice.equalsIgnoreCase("Paper")|| playerChoice.equalsIgnoreCase("Paper") && compChoice.equalsIgnoreCase("Rock"))){
            return "The player wins the kingdom!";
        }
        else {
            return "The computer wins the kingdom!";
        }
    }
}
