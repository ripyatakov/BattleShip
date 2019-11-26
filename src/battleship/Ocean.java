package battleship;
import java.util.Random;

/**
 * Defines the game "board" class
 */
public class Ocean {

    Ship[][] ships = new Ship[10][10];

    int shotsFired;

    int hitCount;

    int shipsSunk;

    /**
     * Set the main settings
     */
    public Ocean(){
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                ships[i][j] = new EmptySea();
            }
        }
    }

    /**
     * Shows the occeping of cell [row, column]
     * @param row
     * @param column
     * @return Occupied?true:false
     */
    public boolean isOccupied(int row, int column){
        return  !(ships[row][column].getShipType().equals( "EmptySea"));
    }

    /**
     * The main method for placement ships in Ocean
     */
    public void placeAllShipsRandomly(){
        Random rnd = new Random();
        int posX;
        int posY;
        boolean horizontal;
        for (int i = 1; i <= 4; i++)
            for(int j = 1; j <= i; j++){
                Ship cur;
                switch (i)
                {
                    case
                        1 : cur = new Battleship(); break;
                    case
                        2 : cur = new Cruiser(); break;
                    case
                        3 : cur = new Destroyer(); break;
                    case
                        4 : cur = new Submarine(); break;

                    default: cur = new Submarine(); break;
                }
                do {
                    posX = rnd.nextInt(10);
                    posY = rnd.nextInt(10);
                    horizontal = rnd.nextBoolean();
                    }   while (!cur.okToPlaceShipAt(posY,posX,horizontal,this));
                cur.placeShipAt(posY,posX,horizontal,this);
            }
    }

    /**
     * Method for shoot at the cell
     * @param row
     * @param column
     * @return <true>shoot on ship</true> <false>shoot on empty sea or sunk ship</false>
     */
    public boolean shootAt(int row, int column){
        if (ships[row][column].isSunk()) return false;
        boolean rtrn = ships[row][column].shootAt(row,column);
        shotsFired++;
        hitCount += rtrn?1:0;
        if (ships[row][column].isSunk())
            shipsSunk++;
        return rtrn;
    }

    /**
     * Getters of shots fired
     * @return
     */
    public int getShotsFired(){
        return shotsFired;
    }
    /**
     * Getters of hit count
     * @return
     */
    public int getHitCount(){
        return hitCount;
    }
    /**
     * Getters of ships sunk
     * @return
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Shows the end of the game
     * @return
     */
    public boolean isGameOver(){
        return shipsSunk == 10;
    }

    /**
     * Getters for ships
     * @return
     */
    public Ship[][] getShipArray(){
        return ships;
    }

    /**
     * Method for print game "desk"
     */
    public void print(){
        String answer = "  ";
        for (int i = 0; i < 10; i++){
            answer += i + " ";
        }
        for (int j = 0; j < 10; j ++) {
            answer += "\n";
            for (int i = -1; i < 10; i++) {
                if (i < 0) {
                    answer += j + " ";
                } else {
                    answer += ships[j][i].getSymbol(j, i) + " ";

                }
            }
        }
        System.out.println(answer);
    }
}
