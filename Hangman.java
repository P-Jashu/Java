import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String result = ranword(words);
        char[] resString = new char[result.length()];
        for (int i = 0; i < result.length(); i++){
            resString[i] = '_';
        }
        int misses = 0;
        String miss = "";

        while(misses < 6){
            System.out.println(gallows[misses]);

            System.out.print("\nWord: ");
            guessedWords(resString);

            System.out.print("\nMiss Guesses: "+miss+"\n");

            System.out.print("\nGuess: ");
            char guess = sc.nextLine().charAt(0);

            if(checkGuess(result, guess)){
                updateing(resString, result, guess);
            }else{
                miss += guess;
                misses++;
            }

            if (Arrays.equals(resString, result.toCharArray())) {
                System.out.print(gallows[misses]);
                System.out.print("\nWord:   ");
                guessedWords(resString);
                System.out.println("\nGOOD WORK!");                
                break;
            }
        }

        if(misses == 6){
            System.out.print(gallows[misses]);
            System.out.println("\nRIP! he died");
            System.out.println("\nYour word was "+result+"\n");
        }

        sc.close();
    }

    public static String ranword(String[] array){
        String ranWord = array[(int) (Math.random()*array.length)];
        return ranWord;
    }

    public static void guessedWords(char[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
    }

    public static boolean checkGuess(String word, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            } 
        }
        return false;
    }
    
    public static void updateing(char[] array, String word, char guess){
        for (int i = 0; i < array.length; i++) {
           if (word.charAt(i) == guess){
            array[i] = guess;
           }
        }
    }

}
