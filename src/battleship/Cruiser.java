package battleship;
/**
 * Defines the three-deck ship
 */
public class Cruiser extends Ship {
    /**
     * Base settings for Cruiser
     */
    public Cruiser(){
        length = 3;
        for (int i = 0; i < length; i++){
            hit[i] = false;
        }
    }
    /**
     * returns Ship type
     */
    @Override
    public String getShipType(){
        return "cruiser";
    }
}
