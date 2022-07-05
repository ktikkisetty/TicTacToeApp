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

    //TODO: Plan all functions needed (with documentation)
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
    public boolean isGridEmpty() {
        return false;
    }
}
