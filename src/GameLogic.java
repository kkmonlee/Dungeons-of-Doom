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
        int[] playerPosition = mapClass.getPlayersPosition();
        System.out.println(playerPosition[0] + " " + playerPosition[1]);

        switch (direction)
        {
            case 'n':


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
    protected String look(char[][] map)
    {
        Map mapClass = new Map();

        String viewPlayer = "";

        int x = mapClass.getPlayersPosition()[0];
        int y = mapClass.getPlayersPosition()[1];

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
