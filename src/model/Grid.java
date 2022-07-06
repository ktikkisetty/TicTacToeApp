package model;

// This class represents the Grid on which Xs and Os will be placed

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Integer> grid; //Actual Grid. 9 spaces possible
    //Grid Layout
    // 0    1     2
    // 3    4     5
    // 6    7     8
    private List<Integer> available; //contains the positions that can be  (possible values are 0 - 8)
    private static int EMPTY = 0;
    private static int X = 1;
    private static int O = 2;

    public Grid() {
        grid = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            grid.add(i, 0); //initialize all positions of grid as being empty
        }

        available = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            available.add(i, i);
        }
    }

    //need size, empty?, get for each, contains for available...

    //EFFECTS: returns number of spaces that can be filled
    public int getNumberOfAvailableSpaces() {
        return available.size();
    }

    //EFFECTS: Makes sure that space is available to be played
    public boolean isSpaceAvailable(int spaceNumber) {
        return available.contains(spaceNumber);
    }

    //EFFECTS: Checks for one possible game end state
    public boolean isFull() {
        return available.isEmpty();
    }

    //EFFECTS: Be given symbols in each spot or lack there of
    public void getGridState() {
        for (int i = 0; i < 9; i++) {
            System.out.println("spot" + i + " contains :" + grid.get(i));
        }
    }

    //EFFECT: Returns 0 if spot is empty, 1 if it's an X, and 2 if O
    public int getSpaceStatus(int spot) {
        return grid.get(spot);
    }

    //EFFECTS: checks if the game is over or needs to continue
    //returns 0 if stalemate
    //returns 1 if X wins
    //returns 2 if O wins
    //returns 3 if game can continue
    public int checkGameState() {
        //false if game is over; true if game can continue

        //Grid Layout
        // 0    1     2
        // 3    4     5
        // 6    7     8

        /* Win conditions:
           The grid is completely full
           The following contain the same symbol
           012
           345
           678
           036
           147
           258
           048
           246
         */

        if (isFull()) {
            return 0;
        }

        if (available.size() > 4) {
            if (getSpaceStatus(0) == getSpaceStatus(2) && getSpaceStatus(2) == getSpaceStatus(1)) {
                return getSpaceStatus(1);
            }
            if (getSpaceStatus(3) == getSpaceStatus(4) && getSpaceStatus(4) == getSpaceStatus(5)) {
                return getSpaceStatus(3);
            }
            if (getSpaceStatus(6) == getSpaceStatus(7) && getSpaceStatus(7) == getSpaceStatus(8)) {
                return getSpaceStatus(6);
            }
            if (getSpaceStatus(0) == getSpaceStatus(3) && getSpaceStatus(3) == getSpaceStatus(6)) {
                return getSpaceStatus(3);
            }
            if (getSpaceStatus(1) == getSpaceStatus(4) && getSpaceStatus(4) == getSpaceStatus(7)) {
                return getSpaceStatus(1);
            }
            if (getSpaceStatus(2) == getSpaceStatus(5) && getSpaceStatus(5) == getSpaceStatus(8)) {
                return getSpaceStatus(2);
            }
            if (getSpaceStatus(0) == getSpaceStatus(4) && getSpaceStatus(4) == getSpaceStatus(8)) {
                return getSpaceStatus(0);
            }
            if (getSpaceStatus(2) == getSpaceStatus(4) && getSpaceStatus(4) == getSpaceStatus(6)) {
                return getSpaceStatus(2);
            }
        }

        return 3;
    }

    //MODIFIES: grid, available
    //EFFECTS: inserts given symbol into the given spot and removes spot from available list
    public void addSymbolToGrid(Symbol symbol, int spot) {

    }

}
