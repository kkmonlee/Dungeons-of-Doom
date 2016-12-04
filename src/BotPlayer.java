import java.util.Random;

/**
 * Starts the game with a Bot Player. Contains code for the bot's decision making.
 *
 * @author : lb809 on 27/11/2016.
 */

public class BotPlayer
{
    private static int currentMove = 0;
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

    /**
     * Checks to see if the move of the bot is valid or not. Prints the bots action if it is.
     *
     * @param tempPos The position which the bot will move into
     * @param tile tile which represents the bots position in the next state, checks if it is valid or not.
     */
    protected void checkMove(int[] tempPos, char tile)
    {
        Map mapClass = new Map();
        GameLogic gameLogic = new GameLogic();

        if (mapClass.getPlayersPosition()[0] == tempPos[0] && mapClass.getPlayersPosition()[1] == tempPos[1])
        {
            System.out.println("Collision with bot! Game over!");
            gameLogic.quitGame();
        }
        else if (Character.toString(tile).equals("#")) System.out.println("The bot moves into a wall.");
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
        else
        {
            mapClass.updateBotPosition(tempPos);
            System.out.println("The bot moved.");
        }
    }



     /**
     * Selects a new move direction
     * @param map this parameter isn't used.
     * @return this return is redundant.
     */
    protected char selectMoveDirection(char[][] map)
    {
        Map mapClass = new Map();
        BotPlayer botPlayer = new BotPlayer();

        int[] playerPos = mapClass.getPlayersPosition();
        int[] botPos = mapClass.getBotPosition();

        int diffX = playerPos[0] - botPos[0];
        int diffY = playerPos[1] - botPos[1];

        System.out.println("dx: " + diffX + " dy: " + diffY);

        Random randomMod = new Random();
        if (currentMove % (randomMod.nextInt(4) + 1) == 0)
        {
            botPlayer.selectNextAction("MOVE N");
        }
        else if (diffY == 0)
        {
            if (diffX > 0) botPlayer.selectNextAction("MOVE E");
            else botPlayer.selectNextAction("MOVE W");
        }
        else if (diffX == 0)
        {
            if (diffY > 0) botPlayer.selectNextAction("MOVE N");
            else botPlayer.selectNextAction("MOVE S");
        }
        else if (Math.abs(diffX) > Math.abs(diffY))
        {
            if (diffX < 0) botPlayer.selectNextAction("MOVE W");
            else botPlayer.selectNextAction("MOVE E");
        }
        else if (Math.abs(diffX) < Math.abs(diffY))
        {
            if (diffY < 0) botPlayer.selectNextAction("MOVE N");
            else botPlayer.selectNextAction("MOVE S");
        }
        else //abs values are equal
        {
            Random random = new Random();
            if (diffX > 0 && diffX == diffY)
            {
                String[] choices = {"MOVE S", "MOVE E"};
                botPlayer.selectNextAction(choices[random.nextInt(choices.length)]);
            }
            else if (diffX < 0 && diffX == diffY)
            {
                String[] choices = {"MOVE N", "MOVE W"};
                botPlayer.selectNextAction(choices[random.nextInt(choices.length)]);
            }
            else if (diffX < 0 && diffY > 0)
            {
                String[] choices = {"MOVE S", "MOVE W"};
                botPlayer.selectNextAction(choices[random.nextInt(choices.length)]);
            }
            else if (diffX > 0 && diffY < 0)
            {
                String[] choices = {"MOVE N", "MOVE E"};
                botPlayer.selectNextAction(choices[random.nextInt(choices.length)]);
            }
            else System.out.println("YOU HAVE A PROBLEM!");
        }
        return 'a';
    }

    /**
    * 2nd Main function
    */
    public static void main(String[] args)
    {
        Random random = new Random();
        BotPlayer botPlayer = new BotPlayer();
        Map mapClass = new Map();
        System.out.println("xB: " + mapClass.getBotPosition()[0] + " yB: " + mapClass.getBotPosition()[1]);
        botPlayer.selectMoveDirection(null);
        currentMove++;
    }
}
