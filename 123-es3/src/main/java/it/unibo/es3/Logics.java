package it.unibo.es3;

public interface Logics {
    
    /**
     * Change the state of slot " " --> " *" or otherwise.
     *
     * @param elem the slot to changed
     * @return the new state a button should show after being pressed
     */
    String hit(Pair<Integer, Integer> elem);


    /**
     * True if it is time to quit (i.e., all slots have "*" in a row).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
