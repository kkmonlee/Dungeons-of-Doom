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
    static ArrayList<ArrayList<Character>> map2 = new ArrayList<>();
    private static int[] playerPosition = new int[2];
    private static int goldRequired = 0;
    private static String mapName;

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
        Map mapClass = new Map();

        char[][] mapArray = new char[mapClass.getMapHeight()][mapClass.getMapWidth()];

        for (int i = 0; i < mapClass.getMapHeight(); i++)
        {
            for (int j = 0; j < mapClass.getMapWidth(); j++)
            {
                mapArray[i][j] = map2.get(i).get(j);
            }
        }

        return mapArray;
    }

    /**
    * @return : The height of the current map.
    */
    protected int getMapHeight()
    {
        return map2.size();
    }

    /**
    * @return : The width of the current map.
    */
    protected int getMapWidth()
    {
        return map2.get(0).size();
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

        try
        {
            String line = input.readLine();

            while (line != null)
            {
                tempMap.add(line);
                line = input.readLine();
            }
            mapName = tempMap.get(0).substring(5, tempMap.get(0).length());
            goldRequired = Integer.parseInt(tempMap.get(1).substring(4, tempMap.get(1).length()));

            for (int i = 2; i < tempMap.size(); i++)
            {
                String row = tempMap.get(i);
                map2.add(new ArrayList<Character>());
                char[] tempArray = row.toCharArray();

                for (int j = 0; j < row.length(); j++)
                {
                    map2.get(i - 2).add(new Character(tempArray[j]));
                }
            }


            //System.out.println(map2);
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
        return map2.get(coordinates[1]).get(coordinates[0]);
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

        int randomHeight = random.nextInt(height + 1);
        int randomWidth = random.nextInt(width + 1);

        if (map2.get(randomHeight).get(randomWidth) == '#' || map2.get(randomHeight).get(randomWidth) == 'G' || map2.get(randomHeight).get(randomWidth) == 'B') newGamePlayerPosition();
        else
        {
            playerPosition[0] = randomWidth;
            playerPosition[1] = randomHeight;
        }
    }
}
