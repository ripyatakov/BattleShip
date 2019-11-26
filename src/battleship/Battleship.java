package battleship;
/**
 * Defines the four-deck ship
 */
public class Battleship extends Ship {
    /**
     * Base settings for Battleship
     */
    public Battleship(){
        length = 4;
        for (int i = 0; i < length; i++){
            hit[i] = false;
        }
    }
    /**
     * returns Ship type
     */
    @Override
    public String getShipType(){
        return "battleship";
    }

}
