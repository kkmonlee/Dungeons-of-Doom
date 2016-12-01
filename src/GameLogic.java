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
        Map mapClass = new Map();
        int[] playerPosition = mapClass.getPlayersPosition();
        System.out.println(playerPosition[0] + " " + playerPosition[1]);

        switch (direction)
        {
            case 'n':
                //if (Character.toString(mapClass.getTile([playerPosition[0] - 1, playerPosition[1]])) System.out.println("BANTER");
        }
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

        String viewPlayer = "";


        for (int i = mapClass.getPlayersPosition()[1] - 2; i <= mapClass.getPlayersPosition()[1] + 2; i++)
        {
            for (int j = mapClass.getPlayersPosition()[0] - 2; j <= mapClass.getPlayersPosition()[0] + 2; j++)
            {
                if (mapClass.getPlayersPosition()[0] == j && mapClass.getPlayersPosition()[1] == i) viewPlayer += "P ";
                else if (i < 0 || i > mapClass.getMapHeight() - 1) viewPlayer += "# ";
                else if (j < 0 || j > mapClass.getMapWidth() - 1) viewPlayer += "# ";
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
