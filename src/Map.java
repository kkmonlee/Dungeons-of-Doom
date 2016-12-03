import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Pack200;

/**
 * Reads and contains in memory the map of the game.
 *
 * @author : lb809 on 27/11/2016.
 */

public class Map
{
    private static int[] playerPosition = new int[2];

    private static int goldRequired = 0;
    private static String mapName;

    private static char[][] myMap = null;

    private static int myMapHeight = 0;
    private static int myMapWidth = 0;

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
     * Reads map from file
     * @param fileName Name of the map's file
     * @throws FileNotFoundException // explain when an IOException will be thrown and why
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
    * @param coordinates: Coordinates of the tile as an array.
    * @return : What the tile at the location requested contains.
    */
    protected char getTile(int[] coordinates)
    {
        return 'a';
    }

    /**
    * Updates the stored in memory location of the player.
    *
    * @param location : New location of the player.
    */
    protected void updatePlayerPosition(int[] location)
    {

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
