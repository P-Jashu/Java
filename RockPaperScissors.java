import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String userChoice = scan.nextLine();

        if (userChoice.equals("yes")){
            System.out.println("Hello");
            System.out.println("rock - paper - scissors, shoot");
            String yourChoice = scan.nextLine();
            String comChoice = computerChoice();
            printResult(yourChoice, comChoice, result(yourChoice, comChoice));
        }else{
            System.out.println("Darn, some other time...!");
        }

        scan.close();
    }

    public static String computerChoice(){
        int rn = (int) (Math.random()*3);
        if (rn == 0){
            return "rock";
        }else if (rn == 1){
            return "paper";
        }else{
            return "scissors";
        }
    }

    public static String result(String yourChoice, String computerChoice) {
        String result = "";
        if ((yourChoice.equals("rock") && computerChoice.equals("scissors")) || 
        (yourChoice.equals("paper") && computerChoice.equals("rock")) ||
        (yourChoice.equals("scissors") && computerChoice.equals("paper"))){
            result = "You win!";
        }else if(yourChoice.equals(computerChoice)){
            result = "It's a tie";
        }else if((yourChoice.equals("scissors") && computerChoice.equals("rock")) ||
        (yourChoice.equals("rock") && computerChoice.equals("paper")) ||
        (yourChoice.equals("paper") && computerChoice.equals("scissors"))){
            result = "You lose";
        }else{
            result = "INVALID CHOICE";
            System.exit(0);
        }
        return result;
      }
 
      public static void printResult(String yourChoice, String computerChoice, String result){
        System.out.println("You chose: " + yourChoice + "\nThe computer chose: " + computerChoice + "\nThe result is: " + result);
      } 
}
