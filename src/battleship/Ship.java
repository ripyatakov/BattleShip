package battleship;

/**
 * Defines the base class for all game cell
 */
public class Ship {
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit = new boolean[4];

    /**
     * Getters for length of ship
     * @return
     */
    public int getLength(){
        return length;
    }

    /**
     * Getters for row of ship's bow
     * @return
     */
    public int getBowRow(){
        return bowRow;
    }

    /**
     * Getters for bow of ship's column
     * @return
     */
    public int getBowColumn(){
    return bowColumn;
    }
    /**
     * Setters for row of ship's bow
     * @return
     */
    public void setBowRow(int row){
        bowRow = row;
    }
    /**
     * Setters for row of ship's column
     * @return
     */
    public void setBowColumn(int column){
        bowColumn = column;
    }

    /**
     * Getters for type of ship
     * @return
     */
    public String getShipType(){
        return "EmptySea";
    }

    /**
     * Determine of possibility to place ship's bow in cell
     * @param row row of place cell
     * @param column column of place cell
     * @param horizontal horizontality of current ship
     * @param ocean reference to ocean, when ship must be placed
     * @return placement's possibility
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean)
    {
       int endRow = row + (horizontal?0:length-1);
       int endColumn = column + (horizontal?length-1:0);
       
       if (row < 0 || endRow > 9 || column < 0 || endColumn > 9)
           return false;
        for (int r = Math.max(0,row-1); r <= Math.min(9,endRow+1); r++) {
            for (int c = Math.max(0,column-1); c <= Math.min(9,endColumn+1); c++) {
                if (ocean.isOccupied(r,c)) return false;
            }
        }
        return true;
    }

    /**
     * Place bow of ship in cell
     * @param row row of place cell
     * @param column column of place cell
     * @param horizontal horizontality of current ship
     * @param ocean reference to ocean, when ship must be placed
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
        bowColumn = column;
        bowRow = row;
        horizontal = horizontal;
        if (!horizontal)
        {
            for (int i = 0; i < length; i++)
            {
                ocean.ships[row + i][column] = this;
            }
            return;
        }
        for (int i = 0; i < length; i++)
        {
            ocean.ships[row][column+ i] = this;
        }
    }

    /**
     * Shot at cell
     * @param row row coordinate
     * @param column column coordinate
     * @return Succes of shoot on nonSunked ship
     */
    public boolean shootAt(int row, int column){
        if (!isSunk()){
            return hit[-bowRow + row - bowColumn + column] = true;
        }
        return false;
    }

    /**
     * @return ship's flooding
     */
    public boolean isSunk(){
        for (int i = 0; i < length; i++){
            if (!hit[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * @return isShunk?"x":"S"
     */
    @Override
    public String toString(){
        if (isSunk()) return "x";
        return "S";
    }

    /**
     * Method to determinate symbol in [row][column] cell
     * @param row Row
     * @param column Column
     * @return
     */
    public String getSymbol(int row, int column){
            if (hit[-bowRow - bowColumn + row + column]){
                if (isSunk())
                    return "x";
                return "S";
            }
            return ".";
    }
}
