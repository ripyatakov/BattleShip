package battleship;
import java.util.Scanner;

/**
 * Defines the main game class
 */
public class BattleshipGame {
    public static void main (String [] args)
    {
        Ocean a = new Ocean();
        int score = 0;
        a.placeAllShipsRandomly();

        while(!a.isGameOver()){
            a.print();
            System.out.println("Enter the shoot coordinates (row column)...");
            int [] shoots = GetInt();
            int x = shoots[0];
            int y = shoots[1];
            a.shootAt(x,y);
            score++;
        }
        a.print();
        System.out.println("Well played! Your score: " + score);
        sc.close();
    }

    static Scanner sc = new Scanner(System.in);
    /**
     * Method for getting numbers for shoot
     * @return new int []{row, column}
     */
    static int[] GetInt(){
        try{
            String s = sc.nextLine();
            var ss = s.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt((ss[1]));
            if (!(x > -1 && x < 10 && y >-1 && y < 10))
                throw new IllegalArgumentException();
            return new int[] {x,y};
        }
        catch(Exception exc) {
            System.out.println("Incorrect input! Repeat please...");
            return GetInt();
        }
    }
}
