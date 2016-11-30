import java.util.Random;

/**
 * Reads and contains in memory the map of the game.
 *
 * Created by lb809 on 27/11/2016.
 */

public class Map
{
    char[][] map =  {   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#' },
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#' },
                        {'#','.','.','.','.','.','.','G','.','.','.','.','.','.','.','.','E','.','#' },
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#' },
                        {'#','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#' },
                        {'#','.','.','.','.','.','.','.','.','.','.','G','.','.','.','.','.','.','#' },
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#' },
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#' },
                        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#' }   };

    private static int[] playerPosition = new int[2];
    private static int goldRequired = 0;

    /*
    * @return : Gold required to exit the current map.
    */
    protected int getGoldRequired()
    {
        return goldRequired;
    }

    /*
    * Initialises the goldRequired variable
    */
    protected void setGoldRequired()
    {
        Random random = new Random();
        goldRequired = random.nextInt(20) + 1;
    }

    /*
    * @return : The map stored in memory.
    */
    protected char[][] getMap()
    {
        return map;
    }

    /*
    * @return : The height of the current map.
    */
    protected int getMapHeight()
    {
        return map.length;
    }

    /*
    * @return : The width of the current map.
    */
    protected int getMapWidth()
    {
        return map[0].length;
    }

    /*
    * @return : The name of the current map.
    */
    protected String getMapName()
    {
        return null;
    }

    /*
    * @return : The position of the player.
    */
    protected int[] getPlayersPosition()
    {
        return playerPosition;
    }

    /*
    * Reads map from file.
    *
    * @param : Name of the map's file.
    */
    protected void readMap(String fileName)
    {

    }

    /*
    * Retrieves a tile on the map. If the location requested is outside bounds of the map, it returns 'X' wall.
    * @param coordinates: Coordinates of the tile as an array.
    * @return : What the tile at the location requested contains.
    */
    protected char getTile(int[] coordinates)
    {
        return map[coordinates[1]][coordinates[0]];
    }

    /*
    * Updates the stored in memory location of the player.
    *
    * @param location : New location of the player.
    */
    protected void updatePlayerPosition(int[] location)
    {

    }

    /*
    * Generates a new starting location of the player.
    *
    */
    protected void newGamePlayerPosition()
    {
        Map mapClass = new Map();
        Random random = new Random();
        int height = mapClass.getMapHeight();
        int width = mapClass.getMapWidth();

        int randomHeight = random.nextInt(height - 1) + 1;
        int randomWidth = random.nextInt(width - 1) + 1;

        if (map[randomHeight][randomWidth] == '#' || map[randomHeight][randomWidth] == 'G' || map[randomHeight][randomWidth] == 'B') newGamePlayerPosition();
        else
        {
            playerPosition[0] = randomHeight;
            playerPosition[1] = randomWidth;
        }
    }
}
