/**
 * Reads and contains in memory the map of the game.
 *
 * Created by lb809 on 27/11/2016.
 */

public class Map
{
    /*
    * @return : Gold required to exit the current map.
    */
    protected int getGoldRequired()
    {
        return 0;
    }

    /*
    * @return : The map stored in memory.
    */
    protected char[][] getMap()
    {
        return null;
    }

    /*
    * @return : The height of the current map.
    */
    protected int getMapHeight()
    {
        return 0;
    }

    /*
    * @return : The width of the current map.
    */
    protected int getMapWidth()
    {
        return 0;
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
        return null;
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
    * Retrieves a tile on the map. If the location requested is outside bounds of the map, it retuns 'X' wall.
    * @param coordinated: Coordinates of the tile as a 2D array.
    * @return : What the tile at the location requested contains.
    */
    protected char getTile(int[] coordinates)
    {
        return 'a';
    }

    /*
    * Updates the stored in memory location of the player.
    *
    * @param location : New location of the player.
    */
    protected void updatePlayerPosition(int[] location)
    {

    }
}
