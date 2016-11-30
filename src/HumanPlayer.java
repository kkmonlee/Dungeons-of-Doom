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
            case "MOVE N":
                return "mn";
            case "MOVE S":
                return "ms";
            case "MOVE E":
                return "me";
            case "MOVE W":
                return "mw";
            case "PICKUP":
                return "p";
            case "LOOK":
                return "l";
            case "QUIT":
                return "q";
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
        GameLogic gameLogic = new GameLogic();
        Map map = new Map();

        System.out.println("Please input your next move: ");
        String response = humanPlayer.processCommand(humanPlayer.getInputFromConsole());

        switch (response)
        {

            case "h":
                System.out.println(gameLogic.hello());
                break;
            case "mn":
                gameLogic.move('n');
                break;
            case "ms":
                gameLogic.move('s');
                break;
            case "me":
                gameLogic.move('e');
                break;
            case "mw":
                gameLogic.move('w');
                break;
            case "p":
                gameLogic.pickup();
                break;
            case "l":
                System.out.println(gameLogic.look(map.getMap()));
                break;
            case "q":
                gameLogic.gameFlick();
                break;
            case "i":
                System.out.println("Invalid input, please try again.");
            default:
                selectNextAction();
        }
    }

    /*
    * 1st Main function
    */
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to the game: Dungeons of Doom!");
        HumanPlayer humanPlayer = new HumanPlayer();
        GameLogic gameLogic = new GameLogic();
        Map mapClass = new Map();

        mapClass.newGamePlayerPosition();
        mapClass.setGoldRequired();

        while (gameLogic.gameRunning())
        {
            humanPlayer.selectNextAction();
        }

        gameLogic.quitGame();
    }
}
