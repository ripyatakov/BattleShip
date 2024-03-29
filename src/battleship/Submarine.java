package battleship;

/**
 * Defines the one-deck ship
 */
public class Submarine extends Ship {
    /**
     * Base settings for Submarine
     */
    public Submarine(){
        length = 1;
        for (int i = 0; i < length; i++){
            hit[i] = false;
        }
    }
    @Override
    /**
     * returns Ship type
     */
    public String getShipType(){
        return "submarine";
    }
}
