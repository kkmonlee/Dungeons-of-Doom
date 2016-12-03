import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 * @author : lb809 on 27/11/2016.
 */

public class HumanPlayer
{
    /**
     * Reads player's input from the console.
     * @return A string containing the input the player entered
     * @throws IOException // explain when an IOException will be thrown and why
     */
    protected String getInputFromConsole() throws IOException
    {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        return consoleInput.readLine();
    }

    /**
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

    /**
     * Uses getInputFromConsole() to read from console, processCommand() to process the reading,
     * and then displays in console the final answer.
     * @throws IOException - Exception thrown when "null" inputted.
     */
    protected void selectNextAction() throws IOException
    {
        HumanPlayer humanPlayer = new HumanPlayer();
        GameLogic gameLogic = new GameLogic();
        Map mapClass = new Map();

        System.out.println("Please input your next move: ");
        String response = humanPlayer.processCommand(humanPlayer.getInputFromConsole());

        switch (response)
        {
            case "h":
                System.out.println(gameLogic.hello());
                break;
            case "mn":
                System.out.println(gameLogic.move('n'));
                break;
            case "ms":
                System.out.println(gameLogic.move('s'));
                break;
            case "me":
                System.out.println(gameLogic.move('e'));
                break;
            case "mw":
                System.out.println(gameLogic.move('w'));
                break;
            case "p":
                System.out.println(gameLogic.pickup());
                break;
            case "l":
                System.out.println(gameLogic.look(mapClass.getMap(), mapClass.getPlayersPosition()));
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

    /**
    * 1st Main function
    */
    public static void main(String[] args) throws IOException
    {
        HumanPlayer humanPlayer = new HumanPlayer();
        GameLogic gameLogic = new GameLogic();
        Map mapClass = new Map();

        mapClass.readMap("examplemap.txt");
        mapClass.newGamePlayerPosition();

        System.out.println("x: " + mapClass.getPlayersPosition()[0] + " y: " + mapClass.getPlayersPosition()[1]);

        System.out.println("Welcome to Dungeons of Doom.\nThe map name is: " + mapClass.getMapName() + ".");

        while (gameLogic.gameRunning())
        {
            if (mapClass.doWeHaveEnoughGold() && Character.toString(mapClass.getTile(mapClass.getPlayersPosition())).equals("E"))
            {
                System.out.println("You have now collected enough gold and you are standing on an exit square. Well done!");
                break;
            }
            humanPlayer.selectNextAction();
        }

        System.out.println("You are now quitting the game.");
        gameLogic.quitGame();


    }
}
