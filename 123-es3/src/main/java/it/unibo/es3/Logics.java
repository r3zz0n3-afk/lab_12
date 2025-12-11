package it.unibo.es3;

public interface Logics {

    /**
     * A method to use for exspand "*" in the grid.
     */
    void expand();

    /**
     * True if it is time to quit (i.e., all slots have "*" in a row).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();

    /**
     * Use for retunr a status of specific cell.
     * 
     * @param p codination of grid
     * @return the status of cell
     */
    String getCell (final Pair<Integer, Integer> p);
}
