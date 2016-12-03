/**
 * Contains the main logic part of the game, as it processes.
 *
 * @author : lb809 on 27/11/2016.
 */

public class GameLogic
{
    private static boolean running = true;

    /**
    * Returns the boolean to check whether the game is still running or not.
    * @return : boolean, if the game is running or not.
    */
    protected boolean gameRunning()
    {
        return running;
    }

    /**
    * Changes the state of running to false.
    */
    protected void gameFlick()
    {
        running = false;
    }

    /**
    * Prints to the console the amount of gold the player needs to exit the game.
    * @return : goldRequired
    */
    protected String hello()
    {
        Map map = new Map();
        return String.valueOf(map.getGoldRequired());
    }

    /**
    * Checks if movement is legal and updates the player's location on the map
    *
    * @param direction : The direction of movement
    * @return : Protocol if success or not.
    */
    protected String move(char  direction)
    {
        Map mapClass = new Map();
        GameLogic gameLogic = new GameLogic();

        int[] playerPosition = mapClass.getPlayersPosition();
        System.out.println(playerPosition[0] + " " + playerPosition[1]);

        switch (direction)
        {
            case 'n':
                int[] tempPosN = {playerPosition[0], playerPosition[1] - 1};
                char tileAbove = mapClass.getTile(tempPosN);
                if (Character.toString(tileAbove).equals("#")) return "You are moving into a wall.";
                else if (Character.toString(tileAbove).equals("E"))
                {
                    mapClass.updatePlayerPosition(tempPosN);
                    return "You are moving onto an exit tile";
                }
                else if (Character.toString(tileAbove).equals("G"))
                {
                    mapClass.updatePlayerPosition(tempPosN);
                    return "You are moving onto a gold tile";
                }
                else if (Character.toString(tileAbove).equals("B"))
                {
                    System.out.println("You moved into the bot. Game over");
                    gameLogic.quitGame();
                    return null;
                }
                else
                {
                    mapClass.updatePlayerPosition(tempPosN);
                    return "You moved successfully";
                }
            case 's':
            int[] tempPosS = {playerPosition[0], playerPosition[1] + 1};
            char tileBelow = mapClass.getTile(tempPosS);
            if (Character.toString(tileBelow).equals("#")) return "You are moving into a wall.";
            else if (Character.toString(tileBelow).equals("E"))
            {
                mapClass.updatePlayerPosition(tempPosS);
                return "You are moving onto an exit tile";
            }
            else if (Character.toString(tileBelow).equals("G"))
            {
                mapClass.updatePlayerPosition(tempPosS);
                return "You are moving onto a gold tile";
            }
            else if (Character.toString(tileBelow).equals("B"))
            {
                System.out.println("You moved into the bot. Game over");
                gameLogic.quitGame();
                return null;
            }
            else
            {
                mapClass.updatePlayerPosition(tempPosS);
                return "You moved successfully";
            }
            case 'e':
            int[] tempPosE = {playerPosition[0] + 1, playerPosition[1]};
            char tileRight = mapClass.getTile(tempPosE);
            if (Character.toString(tileRight).equals("#")) return "You are moving into a wall.";
            else if (Character.toString(tileRight).equals("E"))
            {
                mapClass.updatePlayerPosition(tempPosE);
                return "You are moving onto an exit tile";
            }
            else if (Character.toString(tileRight).equals("G"))
            {
                mapClass.updatePlayerPosition(tempPosE);
                return "You are moving onto a gold tile";
            }
            else if (Character.toString(tileRight).equals("B"))
            {
                System.out.println("You moved into the bot. Game over");
                gameLogic.quitGame();
                return null;
            }
            else
            {
                mapClass.updatePlayerPosition(tempPosE);
                return "You moved successfully";
            }
            case 'w':
                int[] tempPosW = {playerPosition[0] - 1, playerPosition[1]};
                char tileLeft = mapClass.getTile(tempPosW);
                if (Character.toString(tileLeft).equals("#")) return "You are moving into a wall.";
                else if (Character.toString(tileLeft).equals("E"))
                {
                    mapClass.updatePlayerPosition(tempPosW);
                    return "You are moving onto an exit tile";
                }
                else if (Character.toString(tileLeft).equals("G"))
                {
                    mapClass.updatePlayerPosition(tempPosW);
                    return "You are moving onto a gold tile";
                }
                else if (Character.toString(tileLeft).equals("B"))
                {
                    System.out.println("You moved into the bot. Game over");
                    gameLogic.quitGame();
                    return null;
                }
                else
                {
                    mapClass.updatePlayerPosition(tempPosW);
                    return "You moved successfully";
                }


        }
        return null;
    }

    /**
     * Converts the map from a 2D char array to a single string.
     * Should only return a 5x5 grid. With the player in the middle..
     *
     * @param map : The map is the whole grid, in which the player can move.
     * @return : The map in the form of a string.
     */
    protected String look(char[][] map, int[] playerPos)
    {
        Map mapClass = new Map();

        String viewPlayer = "";

        int x = playerPos[0];
        int y = playerPos[1];

        for (int i = y - 2; i <= y + 2; i++)
        {
            for (int j = x - 2; j <= x + 2; j++)
            {
                if (x == j && y == i) viewPlayer += "P ";
                else if (j < 0 || j >= mapClass.getMapWidth()) viewPlayer += "X ";
                else if (i < 0 || i >= mapClass.getMapHeight()) viewPlayer += "X ";
                else viewPlayer += map[j][i] + " ";
            }
            viewPlayer += "\n";
        }
        return viewPlayer;
    }

    /**
    * Processes the player's pickup command, updating the map and the player's gold amount.
    *
    * @return If the player successfully picked-up gold or not.
    */
    protected String pickup()
    {
        return null;
    }

    /**
    * Quits the game, shutting down the game
    */
    protected void quitGame()
    {
        System.exit(0);
    }
}
