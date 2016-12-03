import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Reads and contains in memory the map of the game.
 *
 * @author : lb809 on 27/11/2016.
 */

public class Map
{
    //Player position coordinates in the form {x, y}
    private static int[] playerPosition = new int[2];

    //fields to do with the game play.
    private static int goldRequired = 0;
    private static String mapName;

    //Declaring the 2D mapArray
    private static char[][] myMap = null;

    //Parameters of the mapArray
    private static int myMapHeight = 0;
    private static int myMapWidth = 0;

    //fields to do with picking up gold.
    private static boolean isOnGold = false;
    private static int totalGold = 0;

    /**
     * Evaluates whether or not goldRequired is equal to totalGold.
     * If so @return is true, else returns false.
     *
     * @return the boolean if two values are equal
     */
    protected boolean doWeHaveEnoughGold()
    {
        if (totalGold == goldRequired) return true;
        else return false;
    }

    /**
     * Increments the total gold of the player, after picking up some gold.
     */
    protected void incrementGold()
    {
        totalGold++;
    }

    /**
     * Changes the state of a gold coin to a '.' after getting picked up.
     */
    protected void changeStateOfTile()
    {
        Map mapClass = new Map();
        myMap[mapClass.getPlayersPosition()[0]][mapClass.getPlayersPosition()[1]] = '.';
    }

    /**
     * Returns the value of the isOnGold boolean.
     *
     * @return the value of isOnGold.
     */
    protected boolean getStatusGold()
    {
        return isOnGold;
    }

    /**
     * Resets to default isOnGold value
     */
    protected void resetStatusGold()
    {
        isOnGold = false;
    }

    /**
     * Method which changes the boolean value of isOnGold
     */
    protected void changeStatusGold()
    {
        isOnGold = true;
    }

    /**
     * Initialises the 2D char array for the map.
     */
    protected void initmyMap()
    {
        myMap = new char[myMapWidth][myMapHeight];
    }

    /**
    * @return : Gold required to exit the current map.
    */
    protected int getGoldRequired()
    {
        return goldRequired;
    }

    /**
    * @return : The map stored in memory.
    */
    protected char[][] getMap()
    {
        return myMap;
    }

    /**
    * @return : The height of the current map.
    */
    protected int getMapHeight()
    {
        return myMapHeight;
    }

    /**
    * @return : The width of the current map.
    */
    protected int getMapWidth()
    {
        return myMapWidth;
    }

    /**
    * @return : The name of the current map.
    */
    protected String getMapName()
    {
        return mapName;
    }

    /**
    * @return : The position of the player.
    */
    protected int[] getPlayersPosition()
    {
        return playerPosition;
    }

    /**
     * Reads map from file and puts it in the 2D char array
     * @param fileName Name of the map's file
     * @throws FileNotFoundException - Exception thrown when "null" inputted.
     */
    protected void readMap(String fileName) throws FileNotFoundException
    {
        File theMap = new File(fileName);
        FileReader fileIn = new FileReader(theMap);
        BufferedReader input = new BufferedReader(fileIn);

        ArrayList<String> tempMap = new ArrayList<>();
        Map mapClass = new Map();

        try
        {
            String line = input.readLine();

            while (line != null)
            {
                tempMap.add(line);
                line = input.readLine();
            }

            mapName = tempMap.get(0).substring(5, tempMap.get(0).length());
            tempMap.remove(0);

            goldRequired = Integer.valueOf(tempMap.get(0).substring(4, tempMap.get(0).length()));
            tempMap.remove(0);

            myMapHeight = tempMap.size();
            myMapWidth = tempMap.get(0).length();

            mapClass.initmyMap();

            for (int i = 0; i < myMapHeight; i++)
            {
                String[] singleRow = tempMap.get(i).split("");

                for (int j = 0; j < singleRow.length; j++)
                {
                    myMap[j][i] = singleRow[j].charAt(0);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
    * Retrieves a tile on the map. If the location requested is outside bounds of the map, it returns 'X' wall.
    * @param coordinates: Coordinates of the tile as an array {x, y} format.
    * @return : What the tile at the location requested contains.
    */
    protected char getTile(int[] coordinates)
    {
        return myMap[coordinates[0]][coordinates[1]];
    }

    /**
    * Updates the stored in memory location of the player.
    *
    * @param location : New location of the player.
    */
    protected void updatePlayerPosition(int[] location)
    {
        playerPosition[0] = location[0];
        playerPosition[1] = location[1];
    }

    /**
    * Generates a new starting location of the player.
    *
    */
    protected void newGamePlayerPosition()
    {
        Map mapClass = new Map();
        Random random = new Random();

        int height = mapClass.getMapHeight();
        int width = mapClass.getMapWidth();

        int randomHeight = random.nextInt(height);
        int randomWidth = random.nextInt(width);

        if (myMap[randomWidth][randomHeight] == '#' || myMap[randomWidth][randomHeight] == 'G' || myMap[randomWidth][randomHeight] == 'B') newGamePlayerPosition();
        else
        {
            playerPosition[0] = randomWidth;
            playerPosition[1] = randomHeight;
        }
    }
}
