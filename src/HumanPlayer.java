import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Runs the game with a human player and contains code needed to read inputs.
 *
 * Created by lb809 on 27/11/2016.
 */

public class HumanPlayer
{
    /*
    * Reads player's input from the console.
    * <p>
    * @return : A string containing the input the player entered.
    */
    protected String getInputFromConsole() throws IOException
    {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        return consoleInput.readLine();
    }

    /*
    * Processes the command. It should return a reply in the form of a String, as the protocol dictates.
    * Otherwise it should return the string "Invalid"
    *
    * @param command : Input entered by the user.
    * @return : Processed output or Invalid if the @param command is wrong.
    */
    protected String processCommand(String command)
    {
        switch (command)
        {
            case "HELLO":
                return "h";
            case "MOVEN":
                return "mn";
            case "MOVES":
                return "ms";
            case "MOVEE":
                return "me";
            case "MOVEW":
                return "mw";
            case "PICKUP":
                return "p";
            case "LOOK":
                return "l";
            default:
                return "i";
        }
    }

    /*
    * Uses getInputFromConsole() to read from console, processCommand() to process the reading,
    * and then displays in console the final answer.
    */
    protected void selectNextAction() throws IOException
    {
        HumanPlayer humanPlayer = new HumanPlayer();
        String response = humanPlayer.processCommand(humanPlayer.getInputFromConsole());


    }

    /*
    * Main function
    */
    public static void main(String[] args)
    {
        System.out.println("BANTER");
        char[][] banter2 = {{'1','2','3'}, {'7','8','9'}};
        Map banter3 = new Map();

        GameLogic banter = new GameLogic();
        String esc = banter.look(banter2);
        System.out.println(esc);

        System.out.println(banter3.getMapHeight());
        System.out.println(banter3.getMapWidth());


    }
}
