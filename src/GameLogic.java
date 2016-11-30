/**
 * Contains the main logic part of the game, as it processes.
 *
 * Created by lb809 on 27/11/2016.
 */

public class GameLogic
{
    private static boolean running = true;

    /*
    *
    * @return : if the game is running
    */
    protected boolean gameRunning()
    {
        return running;
    }

    /*
    * Changes the state of running to false.
    */
    protected void gameFlick()
    {
        running = false;
    }

    /*
    *
    * @return : Returns back amount of gold player requires to exit the Dungeon
    */
    protected String hello()
    {
        Map map = new Map();
        return String.valueOf(map.getGoldRequired());
    }

    /*
    * Checks if movement is legal and updates the player's location on the map
    *
    * @param direction : The direction of movement
    * @return : Protocol if success or not.
    */
    protected String move(char  direction)
    {
        return null;
    }

    /* Converts the map from a 2D char array to a single string.
    * Should only return a 5x5 grid. With the player in the middle..
    *
    * @return : A string representation of the game map.
    */
    protected String look(char[][] map)
    {
        Map mapClass = new Map();
        int[] playerPosition = mapClass.getPlayersPosition();
        String viewPlayer = "";

        for (int i = playerPosition[0] - 2; i <= playerPosition[0] + 2; i++)
        {
            for (int j = playerPosition[1] - 2; j <= playerPosition[1] + 2; j++)
            {
                if (playerPosition[0] == i && playerPosition[1] == j) viewPlayer += "P" + " ";
                else if (i < 0) viewPlayer += "#" + " ";
                else if (j < 0) viewPlayer += "#" + " ";
                else viewPlayer += map[i][j] + " ";
            }
            viewPlayer += "\n";
        }
        return viewPlayer;
    }

    /*
    * Processes the player's pickup command, updating the map and the player's gold amount.
    *
    * @return If the player successfully picked-up gold or not.
    */
    protected String pickup()
    {
        return null;
    }

    /*
    * Quits the game, shutting down the application
    */
    protected void quitGame()
    {
        System.exit(0);
    }
}
