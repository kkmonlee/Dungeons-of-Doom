import java.util.Random;

/**
 * Starts the game with a Bot Player. Contains code for the bot's decision making.
 *
 * @author : lb809 on 27/11/2016.
 */

public class BotPlayer
{
    /**
    * Command processing method for BotPlayer.
    *
    * @param command : Input entered by the user.
    * @return : Processed output or Invalid if the @param command is wrong.
    */
    public String processCommand(String command)
    {
        switch (command)
        {
            case "MOVE N":
                return "n";
            case "MOVE S":
                return "s";
            case "MOVE E":
                return "e";
            default:
                return "w";
        }
    }

    /**
    * Selects the next action the bot will perform. Outputs in the console the final result.
    */
    protected void selectNextAction(String move)
    {
        BotPlayer botPlayer = new BotPlayer();
        Map mapClass = new Map();

        String processedCommand = botPlayer.processCommand(move);
        int[] botPosition = mapClass.getBotPosition();

        switch (processedCommand)
        {
            case "n":
                int[] tempPosN = {botPosition[0], botPosition[1] - 1};
                char tileAbove = mapClass.getTile(tempPosN);
                botPlayer.checkMove(tempPosN, tileAbove);
                break;
            case "s":
                int[] tempPosS = {botPosition[0], botPosition[1] + 1};
                char tileBelow = mapClass.getTile(tempPosS);
                botPlayer.checkMove(tempPosS, tileBelow);
                break;
            case "e":
                int[] tempPosE = {botPosition[0] + 1, botPosition[1]};
                char tileRight = mapClass.getTile(tempPosE);
                botPlayer.checkMove(tempPosE, tileRight);
                break;
            default:
                int[] tempPosW = {botPosition[0] - 1, botPosition[1]};
                char tileLeft = mapClass.getTile(tempPosW);
                botPlayer.checkMove(tempPosW, tileLeft);
                break;

        }
    }

    protected void checkMove(int[] tempPos, char tile)
    {
        Map mapClass = new Map();
        GameLogic gameLogic = new GameLogic();

        if (Character.toString(tile).equals("#")) System.out.println("The bot moves into a wall.");
        else if (Character.toString(tile).equals("E"))
        {
            mapClass.updateBotPosition(tempPos);
            System.out.println("The bot moves onto an exit tile.");
        }
        else if (Character.toString(tile).equals("G"))
        {
            mapClass.updateBotPosition(tempPos);
            System.out.println("The bot moves onto a gold tile.");
        }
        else if (mapClass.getBotPosition()[0] == tempPos[0] && mapClass.getBotPosition()[1] == tempPos[1])
        {
            System.out.println("Collision with bot! Game over!");
            gameLogic.quitGame();
        }
        else
        {
            mapClass.updateBotPosition(tempPos);
            System.out.println("The bot moved.");
        }
    }



     /**
     * Selects a new move direction
     * @param map explain what map is
     * @return explain what this returns
     */
    protected char selectMoveDirection(char[][] map)
    {
        return 'a';
    }

    /**
    * 2nd Main function
    */
    public static void main(String[] args)
    {
        Random random = new Random();
        BotPlayer botPlayer = new BotPlayer();
        String[] listOfMoves = {"MOVE N", "MOVE S", "MOVE E", "MOVE W"};

        System.out.println("BANTER BOT");


        int banter2 = random.nextInt(listOfMoves.length);

        botPlayer.selectNextAction(listOfMoves[banter2]);


    }
}
