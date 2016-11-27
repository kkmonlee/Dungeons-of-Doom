/**
 * Contains the main logic part of the game, as it processes.
 *
 * Created by lb809 on 27/11/2016.
 */

public class GameLogic
{
    /*
    *
    * @return : if the game is running
    */
    protected boolean gameRunning()
    {
        return false;
    }

    /*
    *
    * @return : Returns back gold player requires to exit the Dungeon
    */
    protected String hello()
    {
        return null;
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
    *
    * @return : A string representation of the game map.
    */
    protected String look(char[][] map)
    {
        String wholeMap = "";
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++) wholeMap += map[i][j] + " ";
            wholeMap += "\n";
        }
        return wholeMap;
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
